package org.edu.tcms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Comment extends BaseEntity {
    private String commentId;
    private String content;
    private String userId;
    private String replyTo;
}
