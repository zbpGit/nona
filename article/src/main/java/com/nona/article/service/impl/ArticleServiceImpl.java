package com.nona.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nona.article.dao.ArticleDao;
import com.nona.article.entity.Article;
import com.nona.article.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.article.service.impl</b>
 * <br><b>ClassName:ArticleServiceImpl</b>
 * <br><b>Date:2022/2/3 20:33</b>
 */
@Slf4j
@Service
@AllArgsConstructor
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Override
    public List<Article> buckleOne() {
        List<Article> articleList = this.list();
        articleList.stream().forEach(f -> f.setAmount(f.getAmount() - 1));
        this.updateBatchById(articleList);
        return articleList;
    }
}
