package com.highspot.authgateway.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "oauth2_users")
@Getter
@Setter
public class OAuthUsers {
    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    @Field("client_id")
    private String clientId;
    @Field("client_secret")
    private String clientSecret;
    @Field("user_id")
    private String userId;
    @Field("domain_id")
    private String domainId;
    private boolean enabled;

    private List<String> roles;
}
