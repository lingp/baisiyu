package com.lin.apis.login;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.model.user.dtos.ApUserDao;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

public interface LoginControllerApi {
    ResponseResult login(@RequestBody ApUserDao apUserDao, HttpSession session);
}
