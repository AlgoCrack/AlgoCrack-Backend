package com.problem.service.impl;

import java.math.BigInteger;
import java.nio.file.AccessDeniedException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.problem.exception.ResourceNotFoundException;
import com.problem.mapper.ProblemMapper;
import com.problem.mapper.TestCaseMapper;
import com.problem.service.ProblemService;
import com.problem.vo.Problem;
import com.problem.vo.TestCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    ProblemMapper problemMapper;

    @Autowired
    TestCaseMapper testCaseMapper;

    @Autowired
    private SqlSession sqlSession;


    public Problem getProblem(Integer id) {

        if (!problemMapper.isProblemExists(id)) {
            throw new ResourceNotFoundException("The problem does not exist");
        }

        return problemMapper.getProblemById(id);
    };


    public List<Problem> getProblemList() {
        return problemMapper.getProblemList();
    };


    @Transactional
    public void addProblem(Problem problem) throws Exception {

        // 新增 problem
        problemMapper.addProblem(problem);

        // 新增 testCase
        List<TestCase> testCases = problem.getTestCase();
        Integer problemId = problem.getId();
        TestCaseMapper mapper = sqlSession.getMapper(TestCaseMapper.class);
        for (int i = 0; i < testCases.size(); i++) {
            mapper.addTestCase(problemId, testCases.get(i));
        }
    };


    @Transactional
    public void updateProblem(Problem problem) throws Exception {

        if (!problemMapper.isProblemExists(problem.getId())) {
            throw new ResourceNotFoundException("The problem does not exist");
        }

        if (!problemMapper.isProblemUserMatch(problem.getCreatedUserId(), problem.getId())) {
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        problemMapper.updateProblem(problem);

        // 刪除 testCase
        testCaseMapper.deleteTestCase(problem.getId());

        // 新增 testCase
        List<TestCase> testCases = problem.getTestCase();
        Integer problemId = problem.getId();
        TestCaseMapper mapper = sqlSession.getMapper(TestCaseMapper.class);
        for (int i = 0; i < testCases.size(); i++) {
            mapper.addTestCase(problemId, testCases.get(i));
        }
    };


    public void deleteProblem(BigInteger userId, Integer id) throws Exception {

        if (!problemMapper.isProblemExists(id)) {
            throw new ResourceNotFoundException("The problem does not exist");
        }

        if (!problemMapper.isProblemUserMatch(userId, id)) {
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        problemMapper.deleteProblem(id);
    };

}
