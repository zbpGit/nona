package com.nona.article.config.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.order.config.sentinel</b>
 * <br><b>ClassName:SentinelUrlBlockHandler</b>
 * <br><b>Date:2022/1/20 11:27</b>
 */
@Component
public class SentinelUrlBlockHandler implements BlockExceptionHandler {

    public static final Logger log = LoggerFactory.getLogger(SentinelUrlBlockHandler.class);

    /**
     * 接口中加了feign，则 在 控制台中会既会显示接口 也会也是 feign的调用接口
     * 看你 限流哪个 ，限流feign  就走feign的fallback
     * 限流原来接口，则走下面的逻辑
     *
     * @return
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        if (e instanceof FlowException) {
            log.warn("Article服务触发了流控");
            warrperResponse(response, "Article服务触发了流控");
        } else if (e instanceof ParamFlowException) {
            log.warn("Article服务触发了参数流控");
            warrperResponse(response, "Article服务触发了参数流控");
        } else if (e instanceof AuthorityException) {
            log.warn("Article服务触发了授权规则");
            warrperResponse(response, "Article服务触发了授权规则");
        } else if (e instanceof SystemBlockException) {
            log.warn("Article服务触发了系统规则");
            warrperResponse(response, "Article服务触发了系统规则");
        } else {
            log.warn("Article服务触发了降级规则");
            warrperResponse(response, "Article服务触发了降级规则");
        }
    }

    private void warrperResponse(HttpServletResponse httpServletResponse, String errorEnum) throws IOException {
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");

        ObjectMapper objectMapper = new ObjectMapper();
        String errMsg = objectMapper.writeValueAsString(errorEnum);
        httpServletResponse.getWriter().write(errMsg);
    }
}
