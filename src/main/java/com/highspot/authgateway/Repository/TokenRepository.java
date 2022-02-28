package com.highspot.authgateway.Repository;

import com.highspot.authgateway.dao.OAuth2Token;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TokenRepository extends MongoRepository<OAuth2Token, String> {
    OAuth2Token findByPrivateToken(String privateToken);
    OAuth2Token save(OAuth2Token token);
}
