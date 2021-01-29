package com.baisiyu.admin.controller.v1;

import com.baisiyu.admin.service.ArticleAdminService;
import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleAdminDto;
import com.lin.apis.admin.ArticleAdminControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/article")
public class ArticleAdminController implements ArticleAdminControllerApi {
    @Autowired
    private ArticleAdminService articleAdminService;

    @Override
    public ResponseResult getArticleDetails(Long articleId) {
        return null;
    }

    @PostMapping("/add_article")
    @Override
    public ResponseResult addArticle(@RequestBody ArticleAdminDto dto) {
        return articleAdminService.addArticle(dto);
    }
}
