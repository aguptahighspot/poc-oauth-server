package com.highspot.authgateway.Repository;

import com.highspot.authgateway.dao.OAuthUsers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<OAuthUsers, String> {
    OAuthUsers findByClientId(String clientId);
    OAuthUsers save(OAuthUsers user);
}
