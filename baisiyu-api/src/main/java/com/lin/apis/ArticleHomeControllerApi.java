package com.lin.apis;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleHomeDto;
import com.baisiyu.model.articles.pojos.ApArticle;

import java.util.List;

public interface ArticleHomeControllerApi {
    public ApArticle getArticleById(Long id);


    // 加载数据
    public ResponseResult load(ArticleHomeDto dto);

    // 加载更多
    public ResponseResult loadMore(ArticleHomeDto dto);

    // 加载最新
    public ResponseResult loadNew(ArticleHomeDto dto);

}
