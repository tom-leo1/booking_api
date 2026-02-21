package com.resortBooking.Resort.utility;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDate;
import java.util.Date;

@Component
public class JWTUtility {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationMs = 1000*60*30;

    public String generateJWTToken(String username){
        return Jwts.builder()
                .signWith(key)
                .setExpiration(new Date(System.currentTimeMillis()+expirationMs))
                .setIssuedAt(new Date())
                .setSubject(username)
                .compact();
    }
    public String getUserName(String token){
        return Jwts.parserBuilder().setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }
        catch (JwtException e){
                e.getMessage();
            return false;
        }

    }


}
