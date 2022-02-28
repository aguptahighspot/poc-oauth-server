package com.highspot.authgateway.controllers;

import com.highspot.authgateway.common.TokenGenerator;
import com.highspot.authgateway.entities.TokenIntrospectionDTO;
import com.highspot.authgateway.service.TokenService;
import com.highspot.authgateway.dao.OAuth2Token;
import com.highspot.authgateway.entities.TokenDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class OAuth2TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TokenGenerator<String> tokenGenerator;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping(value = "/oauth2/v1/token")
    public ResponseEntity<TokenDTO> tokenEndPoint(@RequestParam("grant_type") String grantType) {
        String publicToken = tokenGenerator.generate();
        TokenDTO tokenDto = new TokenDTO(publicToken, "Bearer");
        OAuth2Token savedToken = tokenService.saveToken(grantType, tokenDto);
        return ResponseEntity.ok(new TokenDTO(publicToken, savedToken.getTokenType(), savedToken.getExpiresIn()));
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping(value = "/oauth2/v1/token/info")
    public ResponseEntity<TokenIntrospectionDTO> tokenIntroInspectionEndpoint(@RequestHeader("token") String publicToken) {
        String privateToken = DigestUtils.sha256Hex(publicToken);
        OAuth2Token token = tokenService.findToken(privateToken);
        if(token == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(TokenIntrospectionDTO.from(publicToken, token));
    }
}
