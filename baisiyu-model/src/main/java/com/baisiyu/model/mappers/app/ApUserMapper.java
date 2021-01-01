package com.baisiyu.model.mappers.app;

import com.baisiyu.model.user.pojos.ApUser;

public interface ApUserMapper {
    ApUser selectById(long id);

    ApUser selectByPhone(String phone);

    ApUser selectByUsername(String name);
}
