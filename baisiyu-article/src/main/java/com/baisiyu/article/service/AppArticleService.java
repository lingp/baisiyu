package com.baisiyu.article.service;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleHomeDto;
import com.baisiyu.model.articles.pojos.ApArticle;

import java.util.List;

public interface AppArticleService {
    public ApArticle getApArticleById(Long id);

    /**
     * 加载数据 1：加载更多，2：加载更新
     * @param dto
     * @param type
     * @return
     */
    public ResponseResult load(ArticleHomeDto dto, Short type);
}
