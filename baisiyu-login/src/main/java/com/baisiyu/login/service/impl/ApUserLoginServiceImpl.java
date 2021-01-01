package com.baisiyu.login.service.impl;

import com.baisiyu.common.response.dtos.ResponseResult;
import com.baisiyu.common.response.enums.AppHttpCodeEnum;
import com.baisiyu.login.service.ApUserLoginService;
import com.baisiyu.model.mappers.app.ApUserMapper;
import com.baisiyu.model.user.pojos.ApUser;
import com.baisiyu.utils.common.MD5;
import com.baisiyu.utils.jwt.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
        // TODO MD5加密
        if(!user.getPassword().equals(apUser.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        apUser.setPassword("");

        Map<String, Object> userMap = new LinkedHashMap<>();
        userMap.put("id", apUser.getId().toString());
        userMap.put("username", apUser.getUsername());
        userMap.put("image", apUser.getImage());
        userMap.put("sex", apUser.getSex());
        userMap.put("status", apUser.getStatus());
        userMap.put("flag", apUser.getFlag());
        userMap.put("created_at", apUser.getCreatedAt());
        userMap.put("updated_at", apUser.getUpdatedAt());

        Map<String,Object> map = new HashMap<>();
        map.put("token", AppJwtUtil.getToken(apUser));
        map.put("user",userMap);

        return ResponseResult.okResult(map);
    }
}
