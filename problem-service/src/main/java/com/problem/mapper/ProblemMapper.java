package com.problem.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.problem.vo.Problem;

@Mapper
public interface ProblemMapper {

    @Select(" SELECT id, created_user_id as createdUserId, title, description, created_date as createdDate " +
    " FROM problem.problem " +
    " WHERE id = #{id} ")
    Problem getProblemById(Integer id);


    @Select(" SELECT id, created_user_id as createdUserId, title, description, created_date as createdDate " +
            " FROM problem.problem; ")
    List<Problem> getProblemList();


    @Insert(" INSERT INTO problem.problem (created_user_id, title, description, created_date) " +
            " VALUES (#{createdUserId}, #{title}, #{description}, #{createdDate}); ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addProblem(Problem problem);


    @Update(" UPDATE problem.problem " +
            " SET created_user_id = #{createdUserId}, " +
            "    title = #{title}, " +
            "    description = #{description}, " +
            "    created_date = #{createdDate} " +
            "WHERE id = #{id} ")
    void updateProblem(Problem problem);


    @Delete(" DELETE FROM problem.problem " +
            " WHERE id = #{id} ")
    void deleteProblem(Integer id);


    @Select(" SELECT EXISTS ( " +
            "   SELECT 1 " +
            "   FROM problem.problem " +
            "   WHERE id = #{problemId} AND created_user_id = #{userId} " +
            " ) AS isMatch ")
    Boolean isProblemUserMatch(BigInteger userId, Integer problemId);

    @Select(" SELECT EXISTS ( " +
            "   SELECT 1 " +
            "   FROM problem.problem " +
            "   WHERE id = #{problemId} " +
            " ) AS isMatch ")
    Boolean isProblemExists(Integer problemId);

}
