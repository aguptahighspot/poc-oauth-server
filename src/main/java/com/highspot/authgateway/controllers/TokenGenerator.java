package com.highspot.authgateway.controllers;

import com.highspot.authgateway.entities.Token;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class TokenGenerator {
    public static final String VERSION = "1";

    public Token generateToken(){
        String publicToken = VERSION + "::" + UUID.randomUUID().toString();
        String privateToken = DigestUtils.sha256Hex(publicToken);
        OffsetDateTime expiresIn = OffsetDateTime.now(ZoneOffset.UTC).plusHours(24L);
        return new Token(publicToken, privateToken, "Bearer", expiresIn.toString());
    }
}
