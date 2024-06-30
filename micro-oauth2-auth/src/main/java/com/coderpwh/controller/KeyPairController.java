package com.coderpwh.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @author coderpwh
 */

@RestController
public class KeyPairController {


    @Resource
    private KeyPair keyPair;


    @GetMapping(value = "/rsa/publicKey")
    public Map<String, Object> getKey() {
         RSAPublicKey  rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(rsaPublicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}
