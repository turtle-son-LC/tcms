package org.edu.tcms.domain;

import lombok.Data;

import java.math.BigInteger;

@Data
public class BaseEntity {
    private Integer deleted;
    private Long createTime;
}
