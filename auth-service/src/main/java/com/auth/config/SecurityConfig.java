package com.auth.config;

import java.util.Collections;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/login", "/").permitAll()  // Allow access to /auth/login and /home
        .anyRequest().authenticated()  // Require authentication for any other request
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.FORBIDDEN))  // Return 403 Forbidden if not authenticated
        .and()
        .oauth2Login()
            .loginPage("/oauth2/authorization/google")  // Use /auth/login for OAuth login
            .defaultSuccessUrl("/", true)  // Redirect to /home after successful login
            .userInfoEndpoint()
            .userService(oauth2UserService());
    return http.build();
  }

  private OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        return userRequest -> {
            OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
            OAuth2User oauth2User = delegate.loadUser(userRequest);

            // 获取用户信息
            Map<String, Object> attributes = oauth2User.getAttributes();
            String email = (String) attributes.get("email");
            String name = (String) attributes.get("name");

            // 创建新的 OAuth2User 对象，并返回
            return new DefaultOAuth2User(
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                    attributes,
                    "name"
            );
        };
    }
}