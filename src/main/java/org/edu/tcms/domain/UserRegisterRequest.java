package org.edu.tcms.domain;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String account;
    private String password;
    private String passwordCheck;
}
