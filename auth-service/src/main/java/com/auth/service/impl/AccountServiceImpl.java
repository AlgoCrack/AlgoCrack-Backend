package com.auth.service.impl;

import java.security.KeyPair;
import java.security.PublicKey;

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

    @Override
    public void addAccount(AccountVO accountVO) {
        accountMapper.addAccount(accountVO);
    }

    @Override
    public String setJWT(AccountVO accountVO, HttpServletResponse response) throws Exception {

        KeyPair keyPair = KeyGeneratorUtil.generateKeyPair();
        String token = JwtUtil.generateToken(keyPair, accountVO.getId());
        System.out.println("Generated JWT: " + token);

        // 输出公钥用于验证
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("Public Key: " + java.util.Base64.getEncoder().encodeToString(publicKey.getEncoded()));

        // 创建 JWT cookie
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(86400); // 過期時間為一天

        // 将 cookie 添加到响应中
        response.addCookie(cookie);
        return null;
    }
}
