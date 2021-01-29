package com.lin.apis.admin;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleAdminDto;
import com.baisiyu.model.articles.dtos.ArticleHomeDto;

public interface ArticleControllerApi {

    // 文章列表

    // 文章详情
    public ResponseResult getArticleDetails(Long articleId);

    // 添加文章
    public ResponseResult addArticle(ArticleAdminDto dto);

    // 修改文章

    // 删除文章

    // 审核文章
}
