package com.baisiyu.admin.service.impl;

import com.baisiyu.admin.service.ArticleAdminService;
import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.articles.dtos.ArticleAdminDto;
import com.baisiyu.model.articles.pojos.ApArticle;
import com.baisiyu.model.articles.pojos.ApArticleContent;
import com.baisiyu.model.mappers.app.ApArticleContentMapper;
import com.baisiyu.model.mappers.app.ApArticlesMapper;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleAdminServiceImpl implements ArticleAdminService {

    @Autowired
    private ApArticlesMapper apArticlesMapper;

    @Autowired
    private ApArticleContentMapper apArticleContentMapper;

    @Override
    public ResponseResult addArticle(ArticleAdminDto dto) {

        // 新增文章基本信息
        ApArticle apArticle = new ApArticle();
        apArticle.setTitle(dto.getTitle());
        apArticle.setAuthorId((long) 1);
        apArticle.setAuthorName("测试");
        apArticle.setChannelId(dto.getChannelId());
        apArticle.setChannelName("测试");
        apArticle.setLayoutType(dto.getLayoutType());
        apArticle.setFlag(dto.getFlag());
        apArticle.setImages(dto.getImages());
        apArticle.setLabels(dto.getLabels());
        apArticle.setProvinceId(1001);
        apArticle.setCityId(1002);
        apArticle.setCountryId(1001);
        apArticle.setPublishTime(new Date());
        apArticle.setSource(1);

        Boolean rs = apArticlesMapper.addArticle(apArticle);

//         新增文章内容
        ApArticleContent apArticleContent = new ApArticleContent();
        apArticleContent.setArticleId(apArticle.getId());
        apArticleContent.setContent(dto.getContent());
        Boolean res = apArticleContentMapper.addArticleContent(apArticleContent);
        dto.setId(apArticle.getId());
        return ResponseResult.okResult(dto);
    }
}
