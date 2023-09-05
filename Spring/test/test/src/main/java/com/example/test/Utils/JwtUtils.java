package com.example.test.Utils;

import com.example.test.Entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.security.jwt.JwtAlgorithms;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class JwtUtils {

    private String token;

    public String generateToken(Users user)
    {
        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(user.getUpdatedAt());
        this.token = Jwts.builder().setClaims(claims).compact();
        return token;
    }

    UUID uuid = UUID.randomUUID();

}
