package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class jwtAuthParams {
    private String jwtTokenSecret;
    private Long tokenExpiredMs;

    public String getJwtTokenSecret() {
        return jwtTokenSecret;
    }
    @Value("${jwtTokenSecret}")
    public void setJwtTokenSecret(String jwtTokenSecret) {
        this.jwtTokenSecret = jwtTokenSecret;
    }

    public Long getTokenExpiredMs() {
        return tokenExpiredMs;
    }
    @Value("${tokenExpiredMs}")
    public void setTokenExpiredMs(Long tokenExpiredMs) {
        this.tokenExpiredMs = tokenExpiredMs;
    }
}
