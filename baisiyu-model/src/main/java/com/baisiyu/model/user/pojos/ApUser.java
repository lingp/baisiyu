package com.baisiyu.model.user.pojos;

import lombok.Data;

import java.util.Date;

@Data
public class ApUser {
    private Long id;
    private String salt;
    private String username;
    private String password;
    private String phone;
    private String image;
    private int sex;
    private int status;
    private int flag;
    private Date createdAt;
    private Date updatedAt;
}
