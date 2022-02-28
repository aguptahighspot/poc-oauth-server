package com.highspot.authgateway.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OpagueTokenGenerator implements TokenGenerator<String> {
    public static final String VERSION = "1";
    @Override
    public String generate() {
        return VERSION + "::" + UUID.randomUUID();
    }
}
