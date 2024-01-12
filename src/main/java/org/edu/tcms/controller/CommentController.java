package org.edu.tcms.controller;

import jakarta.annotation.Resource;
import org.edu.tcms.domain.CommentCreateRequest;
import org.edu.tcms.domain.ResultResponse;
import org.edu.tcms.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/create")
    public ResultResponse createComment(@RequestBody CommentCreateRequest createRequest) {
        return commentService.createComment(createRequest);
    }

    @GetMapping("/count")
    public ResultResponse queryCommentCount() {
        return commentService.queryCommentCount();
    }

    @GetMapping("/page")
    public ResultResponse queryPageList(@RequestParam(defaultValue = "1") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        return commentService.queryPageList(pageNo, pageSize);
    }
}
