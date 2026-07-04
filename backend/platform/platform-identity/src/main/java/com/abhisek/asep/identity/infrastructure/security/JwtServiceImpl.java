package com.abhisek.asep.identity.infrastructure.security;

import com.abhisek.asep.identity.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class JwtServiceImpl implements JwtService {

    private final Key key;

    private final long accessTokenValidity;

    private final long refreshTokenValidity;

    public JwtServiceImpl(@Value("${asep.security.jwt.secret}") String secret, @Value("${asep.security.jwt.access-token-validity}") long accessTokenValidity, @Value("${asep.security.jwt.refresh-token-validity}") long refreshTokenValidity) {

        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.accessTokenValidity = accessTokenValidity;
        this.refreshTokenValidity = refreshTokenValidity;
    }

    @Override
    public String generateAccessToken(User user) {
        return generateToken(user, refreshTokenValidity);
    }

    @Override
    public String generateRefreshToken(User user) {
        return generateToken(user, accessTokenValidity);
    }

    private String generateToken(User user, long validity) {
        Date now = new Date();
        return Jwts.builder().subject(user.getUsername()).claim("userId", user.getId()).claim("email", user.getEmail()).claim("roles", user.getRoles().stream().map(role -> role.getRoleType()).toList()).issuer("asep-platform").audience().add("asep-api").and().id(UUID.randomUUID().toString()).issuedAt(now).expiration(new Date(now.getTime() + validity)).signWith(key, SignatureAlgorithm.HS256).compact();

    }

    @Override
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Claims claims = getClaims(token);
            return !claims.getExpiration().before(new Date()) && "asep-platform".equals(claims.getIssuer()) && claims.getAudience().contains("asep-api");
        } catch (Exception ex) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser().verifyWith((javax.crypto.SecretKey) key).build().parseSignedClaims(token).getPayload();
    }

    public String extractUserId(String token) {
        return getClaims(token).get("userId", String.class);
    }

    public String extractEmail(String token) {
        return getClaims(token).get("email", String.class);
    }

    @SuppressWarnings("unchecked")
    public List<String> extractRoles(String token) {
        return getClaims(token).get("roles", List.class);
    }

}