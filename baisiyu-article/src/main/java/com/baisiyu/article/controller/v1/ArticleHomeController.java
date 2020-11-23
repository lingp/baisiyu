package com.baisiyu.article.controller.v1;

import com.baisiyu.article.service.AppArticleService;
import com.baisiyu.model.articles.pojos.ApArticle;
import com.lin.apis.ArticleHomeControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController implements ArticleHomeControllerApi {

    @Autowired
    AppArticleService appArticleService;

    @RequestMapping("/get-article-by-id")

    public ApArticle getArticleById(Long id) {
        System.out.println(id);
        System.out.println(appArticleService.getApArticleById(id));
        return appArticleService.getApArticleById(id);
    }
}
