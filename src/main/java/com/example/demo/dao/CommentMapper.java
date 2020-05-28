package com.example.demo.dao;

import com.example.demo.model.Comment;
import com.example.demo.model.SecondComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    @Insert("Insert into comment (tieId,commentUsername,commentUserId,commentContent,commentTime,commentTypes,commentPicture) values " +
            "(#{tieId},#{commentUsername},#{commentUserId},#{commentContent},#{commentTime},#{commentTypes},#{commentPicture})")
    void publishComment(Comment comment);

    @Select("Select * from comment where tieId = #{tieId}")
    List<Comment> selectTeiComment(Integer tieId);

    @Delete("Delete from comment where commentId = #{commentId}")
    void deleteTieComment(Integer commentId);

    @Insert("Insert into comment (tieId,commentUsername,commentUserId,commentContent,commentTime,commentTypes,replyCommentId) values " +
            "(#{tieId},#{commentUsername},#{commentUserId},#{commentContent},#{commentTime},#{commentTypes},#{replyCommentId})")
    void publishSecondComment(SecondComment secondComment);

    @Select("Select * from comment where replyCommentId = #{replyCommentId} and commentTypes = #{commentTypes}")
    List<SecondComment> doSelectSecondComment(Integer replyCommentId, Integer commentTypes);

}
