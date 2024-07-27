package com.auth.config;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.auth.service.AccountService;
import com.auth.vo.AccountVO;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
	AccountService accountService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/auth/userInfo", "/auth/login").permitAll()  // Allow access to /auth/login and /home
        .anyRequest().authenticated()  // Require authentication for any other request
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.FORBIDDEN))  // Return 403 Forbidden if not authenticated
        .and()
        .oauth2Login()
            .loginPage("/oauth2/authorization/google")  // Use /auth/login for OAuth login
            .defaultSuccessUrl("/auth/userInfo", true)  // Redirect to /userInfo after successful login
            .userInfoEndpoint()
            .userService(oauth2UserService());

    return http.build();
  }

  private OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        return userRequest -> {
            OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
            OAuth2User oauth2User = delegate.loadUser(userRequest);

            // save user info to the DB
            Map<String, Object> attributes = oauth2User.getAttributes();
            AccountVO accountVO = AccountVO.builder()
              .id(new BigInteger((String)attributes.get("sub")))
              .name((String)attributes.get("name"))
              .givenName((String)attributes.get("given_name"))
              .familyName((String)attributes.get("family_name"))
              .picture((String)attributes.get("picture"))
              .email((String)attributes.get("email"))
              .createdDate(new Date())
              .build();
            accountService.addAccount(accountVO);

            return new DefaultOAuth2User(
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                    attributes,
                    "name"
            );
        };
    }
}
