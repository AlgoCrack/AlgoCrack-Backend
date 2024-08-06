package com.problem.utils;

import java.math.BigInteger;
import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class IdentityUtil {

    @Autowired
    RedisUtil redisUtil;

    public BigInteger getUserId(HttpServletRequest request) {
        PublicKey publicKey = redisUtil.getPublicKey();
        String authorization = request.getHeader("Authorization");
        Claims claim = JwtUtil.parseJwt(authorization, publicKey);
        return new BigInteger((String)claim.get("sub"));
    }
}
