package org.edu.tcms.domain;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private String content;
    private String userId;
    private String replyTo;
    private String rootCommentId;
}
