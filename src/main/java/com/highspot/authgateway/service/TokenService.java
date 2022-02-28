package com.highspot.authgateway.service;

import com.highspot.authgateway.Repository.TokenRepository;
import com.highspot.authgateway.dao.OAuth2Token;
import com.highspot.authgateway.entities.TokenDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public OAuth2Token saveToken(String grantType, TokenDTO tokenDTO){
        String privateToken = DigestUtils.sha256Hex(tokenDTO.getAccessToken());
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        OffsetDateTime expiresIn = now.plusHours(24L);
        OAuth2Token token  = new OAuth2Token();
        token.setPrivateToken(privateToken);
        token.setTokenType(tokenDTO.getTokenType());
        token.setActive(true);
        token.setGrantType(grantType);
        token.setExpiresIn(expiresIn.toString());
        token.setCreatedAt(now.toString());
        token.setUpdatedAt(now.toString());
        return tokenRepository.save(token);
    }

    public OAuth2Token findToken(String privateToken){
        return tokenRepository.findByPrivateToken(privateToken);
    }
}
