package com.example.E_Commerce.register.security;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class jwtUtili {

    private String secretKey = "";
    public jwtUtili() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256"); 
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    private static final long EXPIRATION_TIME = 1000 * 60 * 10; // 10 minutes

     // Generate a JWT token
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>(); 
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .setAudience(username)
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        System.out.println("The fresh generated token  :   " + Keys.hmacShaKeyFor(keyBytes));
       return Keys.hmacShaKeyFor(keyBytes);
    }

    @SuppressWarnings("deprecation")
    public void verify(String authorizationHeader, String email) throws Exception {

      
            try {
                String token = authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : authorizationHeader;
                Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
                // .getBody()
            } catch (Exception e) {
                throw new Exception("Token validation failed", e);
            }
        
        

        // try {
        //     Jwts.parser().setSigningKey(getKey()).parseClaimsJwt(authorizationHeader).getBody();
        // }

        // catch(Exception e) {
        //     throw new Exception();
        // }
        // System.out.println();
    }

    public void validate(String authorizationHeader) throws Exception {

      
        try {
            String token = authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : authorizationHeader;
            Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
            // .getBody()
        } catch (Exception e) {
            throw new Exception("Token validation failed", e);
        }
    }

    public boolean validateToken(String token, String email) {
        return extractUsername(token).equals(email) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
