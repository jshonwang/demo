package com.example.demo.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtTokenProvider {

    private Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Autowired
    private jwtAuthParams jwtAuthParams;

    /**

     * Generate token for user login.

     *

     * @param authentication

     * @return return a token string.

     */

    public String createJwtToken(Authentication authentication) {

        //user name

        String username = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();

        //expire time

        Date expireTime =new Date(System.currentTimeMillis() + jwtAuthParams.getTokenExpiredMs());

        //create token

        String token = Jwts.builder()

                .setSubject(username)

                .setExpiration(expireTime)

                .setIssuedAt(new Date())

                .signWith(SignatureAlgorithm.HS512, jwtAuthParams.getJwtTokenSecret())

                .compact();

        return token;

    }

    /**

     * validate token eligible.

     * if Jwts can parse the token string and no throw any exception, then the token is eligible.

     * @param token a jws string.

     */
    public boolean validateToken(String token) {

        String VALIDATE_FAILED ="validate failed : ";

        try {
            Jwts.parser()
                    .setSigningKey(jwtAuthParams.getJwtTokenSecret())
                    .parseClaimsJws(token);

            return true;

        }catch (Exception ex) {

            //ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, //IllegalArgumentException

            logger.error(VALIDATE_FAILED + ex.getMessage());

            return false;

        }

    }

}
