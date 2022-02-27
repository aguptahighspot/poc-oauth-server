package com.highspot.authgateway.controllers;

import com.highspot.authgateway.entities.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;

@RestController
public class OAuth2TokenController {


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping(value = "/oauth2/v1/token")
    public ResponseEntity<HashMap> tokenEndPoint() {
        Token token = new TokenGenerator().generateToken();
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("access_token", token.getPublicToken());
        hmap.put("token_type", token.getTokenType());
        hmap.put("expires_in", token.getExpiresIn());
        return ResponseEntity.ok(hmap);
    }
}
