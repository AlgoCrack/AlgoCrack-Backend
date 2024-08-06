package com.problem.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.problem.service.ProblemService;
import com.problem.utils.IdentityUtil;
import com.problem.vo.ApiResponse;
import com.problem.vo.Problem;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class ProblemController {

    @Autowired
    ProblemService problemService;

    @Autowired
    IdentityUtil identityUtil;

    @GetMapping("/problem/{id}")
	public ResponseEntity<ApiResponse<Problem>> getProblem(@PathVariable Integer id) {
        Problem result = problemService.getProblem(id);
        ApiResponse<Problem> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", result);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/problem")
	public ResponseEntity<ApiResponse<List<Problem>>> getProblemList() {
        List<Problem> result = problemService.getProblemList();
		ApiResponse<List<Problem>> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", result);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/problem")
	public ResponseEntity<ApiResponse<String>> addProblem(HttpServletRequest request, @Valid @RequestBody Problem problem) throws Exception {
        BigInteger userId = identityUtil.getUserId(request);
        problem.setCreatedUserId(userId);
		problemService.addProblem(problem);
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/problem")
	public ResponseEntity<ApiResponse<String>>  updateProblem(HttpServletRequest request, @Valid @RequestBody Problem problem) throws Exception {
        BigInteger userId = identityUtil.getUserId(request);
        problem.setCreatedUserId(userId);
		problemService.updateProblem(problem);
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/problem/{id}")
	public ResponseEntity<ApiResponse<String>>  deleteProblem(HttpServletRequest request, @PathVariable Integer id) throws Exception {
        BigInteger userId = identityUtil.getUserId(request);
        problemService.deleteProblem(userId, id);
        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", null);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

