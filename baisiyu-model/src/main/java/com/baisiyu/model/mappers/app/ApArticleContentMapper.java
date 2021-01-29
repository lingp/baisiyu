package com.baisiyu.model.mappers.app;

import com.baisiyu.model.articles.pojos.ApArticleContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApArticleContentMapper {

    ApArticleContent selectByArticleId(Long articleId);

    List<ApArticleContent> selectByArticleIds(@Param("articleIds") List<Long> articleIds);


    Boolean addArticleContent(ApArticleContent apArticleContent);
}
