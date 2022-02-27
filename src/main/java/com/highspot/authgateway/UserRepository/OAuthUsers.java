package com.highspot.authgateway.UserRepository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Set;

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
