package com.baisiyu.login.service.impl;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.common.response.enums.AppHttpCodeEnum;
import com.baisiyu.login.service.ApUserLoginService;
import com.baisiyu.model.mappers.app.ApUserMapper;
import com.baisiyu.model.user.pojos.ApUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApUserLoginServiceImpl implements ApUserLoginService {

    @Autowired
    private ApUserMapper apUserMapper;

    @Override
    public ResponseResult login(ApUser user) {
        //验证参数
        if(StringUtils.isEmpty(user.getPhone())|| StringUtils.isEmpty(user.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        ApUser apUser = apUserMapper.selectByPhone(user.getPhone());
        if(apUser==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        if(!user.getPassword().equals(apUser.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        apUser.setPassword("");
        Map<String,Object> map = new HashMap<>();
        map.put("token", apUser.getToken());
        map.put("user",apUser);

        return ResponseResult.okResult(map);
    }
}
