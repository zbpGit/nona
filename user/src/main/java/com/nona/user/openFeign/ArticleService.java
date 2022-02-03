package com.nona.user.openFeign;

import com.nona.user.config.FeignConfig;
import com.nona.user.config.sentinel.factory.ArticleSentielFallbackFactory;
import com.nona.user.util.ResponseFactory;
import com.nona.user.vo.ArticleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.user.openFeign</b>
 * <br><b>ClassName:ArticleService</b>
 * <br><b>Date:2022/1/10 17:46</b>
 */
@FeignClient(value = "article-service", path = "/article", fallbackFactory = ArticleSentielFallbackFactory.class, configuration = FeignConfig.class)
public interface ArticleService {

    @GetMapping(value = "/getList")
    ResponseFactory<List<ArticleVo>> getList();
}
