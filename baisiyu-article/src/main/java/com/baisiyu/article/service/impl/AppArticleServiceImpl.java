package com.baisiyu.article.service.impl;

import com.baisiyu.article.service.AppArticleService;
import com.baisiyu.model.articles.pojos.ApArticle;
import com.baisiyu.model.mappers.ApArticlesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppArticleServiceImpl implements AppArticleService {

    @Autowired
    ApArticlesMapper apArticlesMapper;

    @Override
    public ApArticle getApArticleById(Long id) {
        return apArticlesMapper.selectById(id);
    }
}
