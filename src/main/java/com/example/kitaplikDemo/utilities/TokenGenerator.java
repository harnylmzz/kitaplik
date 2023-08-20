package com.example.kitaplikDemo.utilities;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class TokenGenerator {

    @Value("${jwt-variables.KEY}")
    private String KEY;

    @Value("${jwt-variables.ISSUER}")
    private String ISSUER;

    @Value("${jwt-variables.EXPIRES_ACCESS_TOKEN_MINUTE}")
    private long EXPIRES_ACCESS_TOKEN_MINUTE;

    public String generateToken(Authentication authentication) {

        String userName = ((UserDetails) authentication.getPrincipal()).getUsername();

        return JWT.create()
                .withSubject(userName)
                .withExpiresAt(new Date(System.currentTimeMillis()
                        + (EXPIRES_ACCESS_TOKEN_MINUTE * 60 * 1000)))
                .withIssuer(ISSUER)
                .sign(Algorithm.HMAC256(KEY.getBytes()));
    }

    public DecodedJWT decodedJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(KEY.getBytes());
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();

        try {

            return jwtVerifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("Token verification failed: " + e.getMessage());
        }
    }

}
