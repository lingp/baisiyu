package com.baisiyu.article.controller.v1;

import com.baisiyu.article.service.AppArticleService;
import com.baisiyu.common.constants.articles.ArticleConstans;
import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleHomeDto;
import com.baisiyu.model.articles.pojos.ApArticle;
import com.lin.apis.articles.ArticleHomeControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController implements ArticleHomeControllerApi {

    @Autowired
    AppArticleService appArticleService;

    // 调试用的
    @CrossOrigin
    @RequestMapping("/get-article-by-id")
    public ApArticle getArticleById(Long id) {
        System.out.println(id);
        System.out.println(appArticleService.getApArticleById(id));
        return appArticleService.getApArticleById(id);
    }

    @PostMapping("/load")
    @Override
    public ResponseResult load(@RequestBody ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @PostMapping("/load_more")
    @Override
    public ResponseResult loadMore(@RequestBody ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @PostMapping("/load_new")
    @Override
    public ResponseResult loadNew(@RequestBody ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_NEW);
    }
}
