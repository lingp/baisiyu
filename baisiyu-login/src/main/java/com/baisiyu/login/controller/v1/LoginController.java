package com.baisiyu.login.controller.v1;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.login.service.ApUserLoginService;
import com.baisiyu.model.user.dtos.ApUserDao;
import com.baisiyu.model.user.pojos.ApUser;
import com.lin.apis.login.LoginControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController implements LoginControllerApi {

    @Autowired
    private ApUserLoginService apUserLoginService;

    @PostMapping("/login")
    @Override
    public ResponseResult login(@RequestBody ApUserDao apUserDao) {
        ApUser apUser = new ApUser();
        apUser.setPhone(apUserDao.getUsername()); // TODO, 暂时只支持手机号登录
        apUser.setPhone(apUserDao.getPassword());
        return apUserLoginService.login(apUser);
    }
}
