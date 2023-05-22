package com.moneymatters.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.moneymatters.data.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    public String generateToken(User user) {
        return JWT.create().withIssuer("HardDeveloping")
                .withSubject(user.getEmail()).withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now().plusSeconds(30).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("money-que-e-good-nois-nao-have"));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("money-que-e-good-nois-nao-have"))
                .withIssuer("HardDeveloping")
                .build().verify(token).getSubject();

    }


}
