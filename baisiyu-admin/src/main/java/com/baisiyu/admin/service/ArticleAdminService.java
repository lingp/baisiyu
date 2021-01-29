package com.baisiyu.admin.service;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleAdminDto;
import com.baisiyu.model.articles.pojos.ApArticle;

public interface ArticleAdminService {

    // 新增文章
    public ResponseResult addArticle(ArticleAdminDto dto);

}
