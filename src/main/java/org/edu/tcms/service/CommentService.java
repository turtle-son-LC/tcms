package org.edu.tcms.service;

import jakarta.annotation.Resource;
import org.edu.tcms.domain.*;
import org.edu.tcms.mapper.CommentMapper;
import org.edu.tcms.mapper.UserMapper;
import org.edu.tcms.utls.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserMapper userMapper;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public ResultResponse createComment(CommentCreateRequest createRequest) {
        if (!StringUtils.hasLength(createRequest.getUserId())) {
            return ResultResponse.badRequest("userId不能为空.");
        }
        if (!StringUtils.hasLength(createRequest.getContent())) {
            return ResultResponse.badRequest("评论内容能为空.");
        }
        if (StringUtils.hasLength(createRequest.getReplyTo())) {
            if (!StringUtils.hasLength(createRequest.getRootCommentId())) {
                return ResultResponse.badRequest("回复评论时，rootCommentId不能为空.");
            }
        }

        Comment comment = new Comment();
        comment.setCommentId(UUIDUtil.getShortUUID());
        comment.setUserId(createRequest.getUserId());
        comment.setContent(createRequest.getContent());
        comment.setDeleted(0);
        comment.setCreateTime(System.currentTimeMillis());
        if (StringUtils.hasLength(createRequest.getReplyTo())) {
            comment.setReplyTo(createRequest.getReplyTo());
            comment.setRootCommentId(createRequest.getRootCommentId());
        }
        commentMapper.createNew(comment);

        return ResultResponse.success("成功.");
    }

    public ResultResponse queryCommentCount() {
        Integer count = commentMapper.queryCommentCount();
        return ResultResponse.success(count);
    }

    public ResultResponse queryPageList(Integer pageNo, Integer pageSize) {
        List<Comment> dataList = commentMapper.queryPageList(pageSize, (pageNo - 1) * pageSize);
        List<String> userIds = dataList.stream().map(Comment::getUserId).toList();
        List<User> users = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userIds)) {
            users = userMapper.queryByIds(userIds);
        }

        List<CommentResponse> pageList = convert(dataList, users);

        List<String> rootCommentIds = dataList.stream().map(Comment::getCommentId)
                .filter(StringUtils::hasLength).toList();
        if (!CollectionUtils.isEmpty(rootCommentIds)) {
            List<Comment> replyComments = commentMapper.queryByRootId(rootCommentIds);
            if (!CollectionUtils.isEmpty(replyComments)) {
                List<String> replyUserIds = replyComments.stream().map(Comment::getUserId).filter(userId -> !userIds.contains(userId)).toList();
                if (!CollectionUtils.isEmpty(replyUserIds)) {
                    List<User> replyUsers = userMapper.queryByIds(replyUserIds);
                    users.addAll(replyUsers);
                }

                for (CommentResponse response : pageList) {
                    List<CommentResponse> replyList = buildReplyComments(response, replyComments, users);
                    response.setReplyTo(replyList);
                }
            }
        }

        return ResultResponse.success(pageList);
    }

    private List<CommentResponse> convert(List<Comment> dataList, List<User> users) {
        if (CollectionUtils.isEmpty(dataList)) {
            return new ArrayList<>();
        }
        return dataList.stream().map(data -> {
            CommentResponse response = new CommentResponse();
            BeanUtils.copyProperties(data, response);

            if (!CollectionUtils.isEmpty(users)) {
                for (User user : users) {
                    if (user.getUserId().equals(data.getUserId())) {
                        response.setAccount(user.getAccount());
                    }
                }
            }

            String dateString = sdf.format(new Date(data.getCreateTime()));
            response.setCreateTime(dateString);
            return response;
        }).collect(Collectors.toList());
    }

    private List<CommentResponse> buildReplyComments(CommentResponse parentResponse, List<Comment> replyComments, List<User> users) {
        List<Comment> childComments = replyComments.stream().filter(n -> parentResponse.getCommentId()
                .equals(n.getReplyTo())).toList();
        if (!CollectionUtils.isEmpty(childComments)) {
            List<CommentResponse> childResponses = convert(childComments, users);

            for (CommentResponse childResponse : childResponses) {
                List<CommentResponse> grandChildResponseList = buildReplyComments(childResponse, replyComments, users);
                childResponse.setReplyTo(grandChildResponseList);
            }

            return childResponses;
        }
        return new ArrayList<>();
    }
}
