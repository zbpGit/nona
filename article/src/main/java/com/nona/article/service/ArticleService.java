package com.nona.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nona.article.entity.Article;

import java.util.List;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.article.service</b>
 * <br><b>ClassName:ArticleService</b>
 * <br><b>Date:2022/2/3 20:33</b>
 */
public interface ArticleService extends IService<Article> {

    List<Article> getList();

}
