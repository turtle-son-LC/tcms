package org.edu.tcms.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentResponse {
    private String commentId;
    private String content;
    private String userId;
    private String account;
    private String createTime;
    private List<CommentResponse> replyTo = new ArrayList<>();
}
