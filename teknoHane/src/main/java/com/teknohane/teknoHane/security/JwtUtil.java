package com.teknohane.teknoHane.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

@Component
//JSON Web Token (JWT) oluşturma, doğrulama ve işlemlerini
public class JwtUtil {

    // JWT geçerlilik süresi
    private static final long JWT_TOKEN_VALIDITY = 3600;

    // Gizli anahtar
    private static final String secret = "4dce705682d62cc1ec0e74fdd0d6e52af771401261d9d2249489bbf83f6cc932b2d611dfb9a4a4e9c31d93404f85e07f626bb456c8b84cc7888bd99683614c2c";

    // JWT'den kullanıcı adını alır
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // JWT'den son kullanma tarihini
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // JWT'den belirli bir bilgi
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // JWT'den tüm bilgiler
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    // JWT'nin geçerlilik süresinin dolup dolmadığını kontrol
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // JWT oluşturur
    public String generateToken(UserDetails userDetails) {
        return doGenerateToken(userDetails.getUsername(), userDetails.getAuthorities());
    }

    private String doGenerateToken(String subject, Collection<? extends GrantedAuthority> roles) {
        Claims claims = Jwts.claims().setSubject(subject);
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    // JWT'nin geçerliliğini doğrular
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
