package com.highspot.authgateway.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenDTO {
    private String accessToken;
    private String tokenType;
    private String expires_in;

    public TokenDTO(String accessToken, String tokenType){
        setAccessToken(accessToken);
        setTokenType(tokenType);
    }
}
