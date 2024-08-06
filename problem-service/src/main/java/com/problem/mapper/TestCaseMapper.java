package com.problem.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.problem.vo.TestCase;


@Mapper
public interface TestCaseMapper {

    @Insert("INSERT INTO problem.test_case (problem_id, test_data, created_date) VALUES " +
            "(#{problemId}, #{testCase.testData}, #{testCase.createdDate}) ")
    void addTestCase(Integer problemId, TestCase testCase);

    @Delete(" DELETE FROM problem.test_case " +
            " WHERE problem_id = #{problemId} ")
    void deleteTestCase(Integer problemId);

}
