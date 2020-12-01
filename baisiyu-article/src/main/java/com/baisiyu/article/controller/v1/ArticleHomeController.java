package com.baisiyu.article.controller.v1;

import com.baisiyu.article.service.AppArticleService;
import com.baisiyu.common.constants.articles.ArticleConstans;
import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleHomeDto;
import com.baisiyu.model.articles.pojos.ApArticle;
import com.lin.apis.ArticleHomeControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController implements ArticleHomeControllerApi {

    @Autowired
    AppArticleService appArticleService;

    // 调试用的
    @RequestMapping("/get-article-by-id")
    public ApArticle getArticleById(Long id) {
        System.out.println(id);
        System.out.println(appArticleService.getApArticleById(id));
        return appArticleService.getApArticleById(id);
    }

    @PostMapping("/load")
    @Override
    public ResponseResult load(ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    public ResponseResult loadMore(ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    public ResponseResult loadNew(ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_NEW);
    }


}
