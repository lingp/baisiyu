package com.baisiyu.model.user.pojos;

import lombok.Data;

import java.util.Date;

@Data
public class ApUser {
    private Long id;
    private String token;
    private String username;
    private String password;
    private String phone;
    private String image;
    private Boolean sex;
    private Boolean isCertification;
    private Boolean isIdentityAuthentication;
    private Boolean status;
    private int flag;
    private Date createdAt;
    private Date updatedAt;
}
