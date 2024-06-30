package com.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.vo.ApiResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
	public ResponseEntity<ApiResponse<String>> signIn() {
		ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", "signUp");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<String>> signUp() {
		ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", "signIn");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/test")
	public ResponseEntity<ApiResponse<String>> test() {
		ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", "test");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
