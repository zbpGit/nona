package com.nona.article.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nona.article.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Pierce
 * <b>Description:</b><br>
 * <b>ProjectName:nona</b>
 * <br><b>PackageName:com.nona.article.dao</b>
 * <br><b>ClassName:ArticleDao</b>
 * <br><b>Date:2022/2/3 20:27</b>
 */
@Mapper
public interface ArticleDao extends BaseMapper<Article> {
}
