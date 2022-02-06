package com.nona.article.web;

import com.nona.article.entity.Article;
import com.nona.article.service.ArticleService;
import com.nona.article.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.article.web</b>
 * <br><b>ClassName:ArticleController</b>
 * <br><b>Date:2022/1/8 17:06</b>
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/buckleOne")
    public ResponseFactory<List<Article>> buckleOne() {
        return ResponseFactory.responseSuccess(articleService.buckleOne());
    }
}
