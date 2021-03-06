package com.example.demo.dao;
import com.example.demo.model.Comment;
import com.example.demo.model.SecondComment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {

    @Insert("Insert into comment (tieId,commentUsername,commentUserId,commentContent,commentTime,commentTypes,commentPicture) values " +
            "(#{tieId},#{commentUsername},#{commentUserId},#{commentContent},#{commentTime},#{commentTypes},#{commentPicture})")
    void publishComment(Comment comment);

    @Select("Select * from comment where tieId = #{tieId} and commentTypes = #{commentTypes}")
    List<Comment> selectTeiComment(Integer tieId,Integer commentTypes);

    @Select("Select * from comment where commentId = #{commentId}")
    Comment selectOneComment(Integer commentId);

    @Delete("Delete from comment where commentId = #{commentId}")
    void deleteTieComment(Integer commentId);

    @Insert("Insert into comment (tieId,commentUsername,commentUserId,commentContent,commentTime,commentTypes,replyCommentId) values " +
            "(#{tieId},#{commentUsername},#{commentUserId},#{commentContent},#{commentTime},#{commentTypes},#{replyCommentId})")
    void publishSecondComment(SecondComment secondComment);

    @Select("Select * from comment where replyCommentId = #{replyCommentId} and commentTypes = #{commentTypes}")
    List<SecondComment> doSelectSecondComment(Integer replyCommentId, Integer commentTypes);

    @Update("Update comment set commentLikes = #{commentLikes} where commentId = #{commentId}")
    void updateCommentLikes(Integer commentId,Integer commentLikes);

    @Select("Select * from comment where commentId = #{replyCommentId}")
    Comment selectCommentByReplyCommentId(Integer replyCommentId);

}
