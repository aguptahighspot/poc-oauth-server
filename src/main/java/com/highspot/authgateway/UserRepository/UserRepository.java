package com.highspot.authgateway.UserRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<OAuthUsers, String> {
    OAuthUsers findByClientId(String clientId);
    OAuthUsers save(OAuthUsers user);
}
