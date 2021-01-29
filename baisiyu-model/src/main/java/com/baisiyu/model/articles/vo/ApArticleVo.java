package com.baisiyu.model.articles.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApArticleVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String title;

    private Long authorId;
    private String authorName;
    private String authorPortraitImg;  // 头像img

    private Integer channelId;
    private String channelName;
    private Short layoutType;
    private Byte flag;
    private String images;
    private String labels;
    private Integer likes;
    private Integer collection;
    private Integer comments;
    private Integer views;
    private Integer provinceId;
    private Integer cityId;
    private Integer countyId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")
    private Date publishTime;

    private Boolean syncStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")

    private Date updatedAt;

    private String content;
}
