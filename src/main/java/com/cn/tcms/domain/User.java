package com.cn.tcms.domain;

import lombok.Data;

import java.math.BigInteger;

@Data
public class User {
    private String id;
    private String name;
    private String password;
    private String phoneNum;
    private String email;
    private Integer deleted;
    private BigInteger createTime;
}
