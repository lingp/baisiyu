package com.baisiyu.model.articles.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleHomeDto {
    // 省
    Integer provinceId;
    // 市
    Integer cityId;
    // 区
    Integer countryId;
    // 最大时间
    Date maxBeHotTime;
    // 最小时间
    Date minBeHotTime;
    // 分页size
    Integer size;

    // 频道ID
    Integer channelId;
}
