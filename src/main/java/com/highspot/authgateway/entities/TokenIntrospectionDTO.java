package com.highspot.authgateway.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.highspot.authgateway.dao.OAuth2Token;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenIntrospectionDTO {
    private String publicToken;
    private String tokenType;
    private String clientId;
    private String expiresIn;
    private String createdAt;
    private String expiredAt;
    private String updatedAt;
    private boolean active;
    private String grantType;
    private Set<String> scopes;

    public static TokenIntrospectionDTO from(String accessToken, OAuth2Token token)
    {
        TokenIntrospectionDTO tokenIntrospectionDTO = new TokenIntrospectionDTO();
        tokenIntrospectionDTO.setClientId(token.getClientId());
        tokenIntrospectionDTO.setTokenType(token.getTokenType());
        tokenIntrospectionDTO.setActive(token.isActive());
        tokenIntrospectionDTO.setPublicToken(accessToken);
        tokenIntrospectionDTO.setScopes(token.getScopes());
        tokenIntrospectionDTO.setGrantType(token.getGrantType());
        tokenIntrospectionDTO.setCreatedAt(token.getCreatedAt());
        tokenIntrospectionDTO.setExpiredAt(token.getExpiredAt());
        return tokenIntrospectionDTO;
    }
}
