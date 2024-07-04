package com.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.service.HelloService;
import com.auth.vo.ApiResponse;
import com.auth.vo.HelloRequestVO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class HelloController {

	@Autowired
	private HelloService helloService;

	@GetMapping("/echo")
	public ResponseEntity<ApiResponse<String>> echo(@RequestParam String input) {
		String data = helloService.echo(input);
		ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", data);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/hello")
	public ResponseEntity<ApiResponse<String>> hello(@Valid @RequestBody HelloRequestVO helloRequestVO) {
		String data = helloService.hello(helloRequestVO);
		ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "successed", data);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// 用來測試 google auth 是否登入
	@GetMapping("/")
	public Map<String, Object> testOauth(@AuthenticationPrincipal OAuth2User oauth2User) {
		return oauth2User.getAttributes();
	}
}
