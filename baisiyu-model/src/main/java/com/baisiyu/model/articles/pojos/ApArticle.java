package com.baisiyu.model.articles.pojos;

import com.baisiyu.model.annotation.DateConvert;
import com.baisiyu.model.annotation.IdEncrypt;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ApArticle {
    private Long id;
    private String title;
    private Long authorId;
    private String authorName;
    private Long channelId;
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
    private Integer countryId;
    private Integer source;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")
    private Date publishTime;
    private Boolean syncStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")
    private Date updatedAt;
}
