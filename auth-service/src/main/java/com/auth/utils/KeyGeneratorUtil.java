package com.auth.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Base64;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KeyGeneratorUtil {

    private PrivateKey privateKey;

    private PublicKey publicKey;

    private static final String KEY_PREFIX = "publicKey:";

    private static final Integer MAX_RETRIES = 10;

    private static final long RETRY_DELAY = 5000; // 5 seconds

    @Autowired
    RedisUtil redisUtil;

    @PostConstruct
    public void init() throws Exception {
        // 程式執行後，產生RSA key pair，使用私鑰對 JWT 簽名，公鑰驗證 JWT
        KeyPair keyPair = generateKeyPair();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();

        // 將公鑰放到redis中
        PublicKey publicKey = keyPair.getPublic();

        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                redisUtil.save(KEY_PREFIX, Base64.getEncoder().encodeToString(publicKey.getEncoded()));
            }  catch (Exception e) {
                log.error("Failed to connect to Redis, attempt " + attempt);
                if (attempt == MAX_RETRIES) {
                    log.error("Redis connection failed");
                    System.exit(1);
                }
                Thread.sleep(RETRY_DELAY);
            }
        
        }
    }

    public KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.genKeyPair();
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
