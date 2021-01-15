package com.baisiyu.model.mappers.app;

import com.baisiyu.model.user.pojos.ApUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApUserMapper {
    ApUser selectById(long id);

    ApUser selectByPhone(String phone);

    ApUser selectByUsername(String name);

    List<ApUser> selectByIds(@Param("ids") List<Long> ids);
}
