package com.nona.user.config.sentinel.factory;

import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.nona.user.openFeign.ArticleService;
import com.nona.user.util.ResponseFactory;
import com.nona.user.vo.ArticleVo;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.config.sentinel</b>
 * <br><b>ClassName:ArticleSentielFallbackFactory</b>
 * <br><b>Date:2022/1/20 11:48</b>
 */
@Component
public class ArticleSentielFallbackFactory implements FallbackFactory<ArticleService> {

    public static final Logger log = LoggerFactory.getLogger(ArticleSentielFallbackFactory.class);

    @Override
    public ArticleService create(Throwable e) {
        return new ArticleService() {
            @Override
            public ResponseFactory<List<ArticleVo>> buckleOne() {
                String message = null;
                if (e instanceof FlowException) {
                    message = "Article服务调用时触发了流控";
                } else if (e instanceof ParamFlowException) {
                    message = "Article服务调用时触发了参数流控";
                } else if (e instanceof AuthorityException) {
                    message = "Article服务调用时触发了授权规则";
                } else if (e instanceof SystemBlockException) {
                    message = "Article服务调用时触发了系统规则";
                } else {
                    message = "Article服务调用时触发了降级规则";
                }
                return ResponseFactory.responseSuccess(message);
            }
        };
    }
}
