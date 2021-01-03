package com.baisiyu.login.controller.v1;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.common.response.enums.AppHttpCodeEnum;
import com.baisiyu.login.service.ApUserLoginService;
import com.baisiyu.model.user.dtos.ApUserDao;
import com.baisiyu.model.user.pojos.ApUser;
import com.baisiyu.utils.common.MD5;
import com.google.code.kaptcha.Producer;
import com.lin.apis.login.LoginControllerApi;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController implements LoginControllerApi {

    @Autowired
    private ApUserLoginService apUserLoginService;

    @Autowired
    private Producer kaptchaProducer;

    @PostMapping("/login")
    @Override
    public ResponseResult login(@RequestBody ApUserDao apUserDao, HttpSession session) {
        ApUser apUser = new ApUser();
        apUser.setPhone(apUserDao.getUsername()); // TODO, 暂时只支持手机号登录
        apUser.setPassword(MD5.encrypt(apUserDao.getPassword()));

        String captcha = ((String) session.getAttribute("captcha")).toLowerCase();

        if (StringUtils.isEmpty(apUserDao.getCaptcha()) || !captcha.equals(apUserDao.getCaptcha().toLowerCase())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.CAPTCHA_ERROR);
        }

        return apUserLoginService.login(apUser);
    }

    @RequestMapping(path = "/captcha", method = RequestMethod.GET)
    public void getCaptcha(HttpServletResponse response, HttpSession session) {
        // 生成验证码
        String captcha = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(captcha);

        // 将验证码存入session
        session.setAttribute("captcha", captcha);

        // 将图片输出给浏览器
        response.setContentType("image/png");

//        System.out.println(session.getId());

        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
        }
    }
}
