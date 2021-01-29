package com.baisiyu.model.articles.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class ArticleAdminDto {
    private Long id;
    private String title;
    private Long channelId;
    private Short layoutType;
    private Byte flag;
    private String images;
    private String labels;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:s", timezone = "GMT+8")
    private Date publishTime;
}
