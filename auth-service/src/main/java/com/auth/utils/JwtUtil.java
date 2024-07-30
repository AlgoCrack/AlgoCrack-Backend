package com.auth.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.PrivateKey;
import java.util.Date;
import java.math.BigInteger;

public class JwtUtil {
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    public static String generateToken(PrivateKey privateKey, BigInteger userId) {

        return Jwts.builder()
                .setSubject(userId.toString())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }
}
