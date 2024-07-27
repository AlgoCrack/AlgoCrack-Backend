package com.auth.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public void googleLogin(HttpServletResponse response) throws IOException {

        response.sendRedirect("/oauth2/authorization/google");

    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        if (authentication != null && authentication instanceof OAuth2AuthenticationToken) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        response.sendRedirect("/auth/userInfo");;
    }

    // 用來測試 google auth 是否登入
	@GetMapping("/userInfo")
	public Map<String, Object> testOauth(@AuthenticationPrincipal OAuth2User oauth2User) {
        if (oauth2User != null) {
            return oauth2User.getAttributes();
        } else {
            return Collections.emptyMap();
        }
	}
}
