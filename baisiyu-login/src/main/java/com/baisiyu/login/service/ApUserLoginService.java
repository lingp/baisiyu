package com.baisiyu.login.service;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.user.pojos.ApUser;

public interface ApUserLoginService {
    /**
     * 根据用户名和密码登录验证
     */
    ResponseResult login(ApUser user);
}
