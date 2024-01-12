package org.edu.tcms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.tcms.domain.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    void createNew(Comment comment);

    Integer queryCommentCount();

    List<Comment> queryPageList(Integer pageSize, Integer offset);

    List<Comment> queryByRootId(@Param(value = "rootCommentIds") List<String> rootCommentIds);
}
