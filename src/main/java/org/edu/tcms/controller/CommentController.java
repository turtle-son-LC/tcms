package org.edu.tcms.controller;

import org.edu.tcms.domain.CommentCreateRequest;
import org.edu.tcms.domain.ResultResponse;
import org.edu.tcms.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tcms/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/create")
    public ResultResponse createComment(@RequestBody CommentCreateRequest createRequest) {
        System.out.println("createComment");
        return commentService.createComment(createRequest);
    }

    @GetMapping("/count")
    public ResultResponse queryCommentCount() {
        System.out.println("queryCommentCount");
        return commentService.queryCommentCount();
    }

    @GetMapping("/page")
    public ResultResponse queryPageList(@RequestParam(defaultValue = "1") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println("queryPageList");
        return commentService.queryPageList(pageNo, pageSize);
    }
}
