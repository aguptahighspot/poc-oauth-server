package com.highspot.authgateway.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "oauth2_token")
public class OAuth2Token {

    @Id
    @Field("token")
    private String privateToken;
    @Field("token_type")
    private String tokenType;
    @Field("client_id")
    private String clientId;
    @Field("expired_in")
    private String expiresIn;
    @Field("created_at")
    private String createdAt;
    @Field("expired_at")
    private String expiredAt;
    @Field("updated_at")
    private String updatedAt;
    private boolean active;
    @Field("grant_type")
    private String grantType;
    @Field("scope")
    private Set<String> scopes;
}
