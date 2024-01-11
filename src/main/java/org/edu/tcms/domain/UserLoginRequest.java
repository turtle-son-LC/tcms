package org.edu.tcms.domain;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String account;
    private String password;
}
