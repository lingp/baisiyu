package com.baisiyu.article.service.impl;

import com.alibaba.fastjson.JSON;
import com.baisiyu.article.service.AppArticleService;
import com.baisiyu.common.constants.articles.ArticleConstans;
import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleHomeDto;
import com.baisiyu.model.articles.pojos.ApArticle;
import com.baisiyu.model.articles.pojos.ApArticleContent;
import com.baisiyu.model.articles.vo.ApArticleVo;
import com.baisiyu.model.mappers.app.ApArticleContentMapper;
import com.baisiyu.model.mappers.app.ApArticlesMapper;
import com.baisiyu.model.mappers.app.ApUserMapper;
import com.baisiyu.model.user.pojos.ApUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppArticleServiceImpl implements AppArticleService {

    private static final short MAX_PAGE_SIZE = 50;


    @Autowired
    ApArticlesMapper apArticlesMapper;

    @Autowired
    ApArticleContentMapper apArticleContentMapper;

    @Autowired
    ApUserMapper apUserMapper;

    @Override
    public ApArticle getApArticleById(Long id) {
        return apArticlesMapper.selectById(id);
    }

    @Override
    public ResponseResult load(ArticleHomeDto dto, Short type) {

        if (dto == null) {
            dto = new ArticleHomeDto();
        }

        System.out.println(dto.getChannelId());

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


        // 判断是否用户存在，存在先取用户推荐的，没有再取默认 TODO
        ApUser apUser = null;
        List<ApArticle> articles = null;
        List<ApArticleVo> voApArticles = new ArrayList<>();

        if (apUser == null) {
            // TODO ，这代码，要去重新弄下
            // 获取文章列表
            articles = apArticlesMapper.getApArticleList(dto, type);
            System.out.println(articles);
            List<Long> articleIds = new ArrayList<>();
            List<Long> userIds = new ArrayList<>();

            for (ApArticle article : articles) {
                articleIds.add(article.getId());
                userIds.add(article.getAuthorId());
            }

            if (!articleIds.isEmpty()) {
                List<ApArticleContent> apArticleContents = apArticleContentMapper.selectByArticleIds(articleIds);
                List<ApUser> apUsers = apUserMapper.selectByIds(userIds);

                for (ApArticle article : articles) {

                    ApArticleVo apArticleVo = new ApArticleVo();

                    BeanUtils.copyProperties(article, apArticleVo);

                    for (ApArticleContent content : apArticleContents) {
                        if (content.getArticleId() == article.getId()) {
                            apArticleVo.setContent(content.getContent());
                        }
                    }

                    for (ApUser user: apUsers) {
                        if (user.getId() == article.getAuthorId()) {
                            apArticleVo.setAuthorPortraitImg(user.getImage());
                            apArticleVo.setAuthorName(user.getUsername());
                        }
                    }
                    voApArticles.add(apArticleVo);
                }
            }
        } else {

        }
        return ResponseResult.okResult(voApArticles);
    }


}
