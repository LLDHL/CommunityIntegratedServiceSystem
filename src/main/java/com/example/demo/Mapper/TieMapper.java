package com.example.demo.Mapper;

import com.example.demo.model.Tie;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TieMapper {

    /*发帖*/
    @Insert("insert into tie (publishUserId,publishUsername,publishUserCommunity,title,content,label,publishTime,pictureAddress,tieTypes) " +
            "values (#{publishUserId},#{publishUsername},#{publishUserCommunity},#{title},#{content},#{label},#{publishTime},#{pictureAddress},#{tieTypes})")
    void publish(Tie tie);

    /*删帖*/
    @Delete("delete from tie where id = #{id}")
    void deleteTie(Integer id);

    /*修改贴*/
    @Update("update tie set title = #{title},content = #{content},label = #{label},pictureAddress = #{pictureAddress} where id = #{id}")
    void updateTie(Tie ite);

    /*查询所有帖子*/
    @Select("select * from tie")
    List<Tie> selectAllTie();

    /*查询个人的所有帖子*/
    @Select("select * from tie where publishUserId = #{publishUserId}")
    List<Tie> selectPersonTie(Integer publishUserId);

    /* 查询某一个帖子 */
    @Select("select * from tie where id = #{id}")
    Tie selectOneTie(Integer id);

    /* 查询某一个帖子时，增加浏览数 */
    @Update("update tie set browse = #{browse} where id = #{id}")
    void rememberBrowse(Integer browse,Integer id);

}
