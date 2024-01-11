package org.edu.tcms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {
    private String userId;
    private String account;
    private String userName;
    private String password;
    private String title;
    private String phoneNum;
    private String email;
}
