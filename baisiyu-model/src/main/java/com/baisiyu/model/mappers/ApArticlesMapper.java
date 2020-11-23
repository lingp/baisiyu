package com.baisiyu.model.mappers;

import com.baisiyu.model.articles.dtos.ArticleHomeDto;
import com.baisiyu.model.articles.pojos.ApArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApArticlesMapper {

    ApArticle selectById(Long id);

    // 获取文章列表
    List<ApArticle> getApArticleList(@Param("dto") ArticleHomeDto dto, @Param("type") Short type);
}
