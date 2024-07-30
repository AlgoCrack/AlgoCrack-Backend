package com.auth.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.mapper.AccountMapper;
import com.auth.service.AccountService;
import com.auth.utils.JwtUtil;
import com.auth.utils.KeyGeneratorUtil;
import com.auth.vo.AccountVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    KeyGeneratorUtil keyGeneratorUtil;

    @Override
    public void addAccount(AccountVO accountVO) {
        accountMapper.addAccount(accountVO);
    }

    @Override
    public void setJWT(AccountVO accountVO, HttpServletResponse response) {
        try {
            String token = JwtUtil.generateToken(keyGeneratorUtil.getPrivateKey(), accountVO.getId());

            // 將 JWT 放到 cookie
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(86400); // 過期時間為一天

            response.addCookie(cookie);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
