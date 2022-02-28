package com.highspot.authgateway.common;

public interface TokenGenerator<T> {
    T generate();
}
