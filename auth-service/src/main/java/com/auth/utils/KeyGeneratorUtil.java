package com.auth.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtil {
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.genKeyPair();
    }
}
