package com.example.demo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class jwtUtil {

    private jwtUtil()
    {}


    public static Map<String,String> generateToken(String username)

    {
        final Date tokenCreationDate = new Date();
        final Date tokenExpirationDate=Date.from(Instant.now().plusMillis(1000000));

    String token =  Jwts.builder().setSubject(username).setIssuedAt(tokenCreationDate).setExpiration(tokenExpirationDate).signWith(SignatureAlgorithm.HS256,"SecretKey")
                .compact();

    Map<String,String> tokenWithMessage= new LinkedHashMap<>();
    tokenWithMessage.put("token", token);   
    tokenWithMessage.put("message","The User is Authorized Successfully"); 
    return tokenWithMessage; 
    }
}
