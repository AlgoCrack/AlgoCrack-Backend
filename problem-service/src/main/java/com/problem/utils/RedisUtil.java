package com.problem.utils;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RedisUtil {

    private static final String PUBLIC_KEY_NAME = "publicKey:";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public PublicKey getPublicKey() {
        try {
            String base64EncodedKey = redisTemplate.opsForValue().get(PUBLIC_KEY_NAME);
            if (base64EncodedKey != null) {
                byte[] decodedKey = Base64.getDecoder().decode(base64EncodedKey);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
                return keyFactory.generatePublic(keySpec);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
