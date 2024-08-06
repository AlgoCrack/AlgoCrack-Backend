package com.problem.service;

import java.math.BigInteger;
import java.util.List;

import com.problem.vo.Problem;

public interface ProblemService {

    Problem getProblem(Integer id);

    List<Problem> getProblemList();

    void addProblem(Problem problem) throws Exception;

    void updateProblem(Problem problem) throws Exception;

    void deleteProblem(BigInteger userId, Integer id) throws Exception;
}

