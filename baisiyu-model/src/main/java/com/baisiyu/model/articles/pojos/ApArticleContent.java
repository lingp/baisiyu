package com.baisiyu.model.articles.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ApArticleContent {
    private Integer id;
    private Integer articleId;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")
    private Date updatedAt;
}
