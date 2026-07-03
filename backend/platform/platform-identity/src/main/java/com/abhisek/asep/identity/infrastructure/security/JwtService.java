package com.abhisek.asep.identity.infrastructure.security;

import com.abhisek.asep.identity.domain.model.User;

import java.util.List;

public interface JwtService {

    String generateAccessToken(User user);

    String generateRefreshToken(User user);

    String extractUsername(String token);

    boolean validateToken(String token);

    String extractUserId(String token);

    String extractEmail(String token);

    List<String> extractRoles(String token);

}