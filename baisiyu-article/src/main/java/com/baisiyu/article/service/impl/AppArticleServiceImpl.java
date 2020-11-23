package com.baisiyu.article.service.impl;

import com.baisiyu.article.service.AppArticleService;
import com.baisiyu.common.constants.articles.ArticleConstans;
import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleHomeDto;
import com.baisiyu.model.articles.pojos.ApArticle;
import com.baisiyu.model.mappers.ApArticlesMapper;
import com.baisiyu.model.user.ApUser;
import com.mchange.lang.IntegerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Service
public class AppArticleServiceImpl implements AppArticleService {

    private static final short MAX_PAGE_SIZE = 50;


    @Autowired
    ApArticlesMapper apArticlesMapper;

    @Override
    public ApArticle getApArticleById(Long id) {
        return apArticlesMapper.selectById(id);
    }

    @Override
    public ResponseResult load(ArticleHomeDto dto, Short type) {

        if (dto == null) {
            dto = new ArticleHomeDto();
        }

        if (type.equals(ArticleConstans.LOADTYPE_LOAD_NEW)) {
            dto.setMaxBeHotTime(new Date());
        } else {
            dto.setMinBeHotTime(new Date());
        }

        Integer size = dto.getSize();
        if (size == null || size <= 0 || size > MAX_PAGE_SIZE) {
            size = 20;
        }
        dto.setSize(Math.min(size, MAX_PAGE_SIZE));


        // 判断是否用户存在，存在先取用户推荐的，没有再取默认
        ApUser apUser = null;
        List<ApArticle> articles = null;
        System.out.println(dto);

        if (apUser == null) {
           articles = apArticlesMapper.getApArticleList(dto, type);
        } else {

        }

        return ResponseResult.okResult(articles);
    }




}
