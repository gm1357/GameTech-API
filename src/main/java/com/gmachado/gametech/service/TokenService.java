package com.gmachado.gametech.service;

import com.gmachado.gametech.domain.UserDomain;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${gametech.jwt.expiration}")
    private String expiration;

    @Value("${gametech.jwt.secret}")
    private String secret;

    public String getToken(Authentication authentication) {
        UserDomain loggedUser = (UserDomain) authentication.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Gametech")
                .setSubject(loggedUser.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secret).build();
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
        return Long.parseLong(claimsJws.getBody().getSubject());
    }
}
