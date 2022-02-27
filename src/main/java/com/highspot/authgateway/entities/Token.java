package com.highspot.authgateway.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Token {
    private String publicToken;
    private String privateToken;
    private String tokenType;
    private String expiresIn;
}
