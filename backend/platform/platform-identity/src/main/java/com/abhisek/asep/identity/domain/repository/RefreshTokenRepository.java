package com.abhisek.asep.identity.domain.repository;

import com.abhisek.asep.identity.domain.model.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {

    RefreshToken save(RefreshToken token);

    Optional<RefreshToken> findByToken(String token);

    void deleteByUserId(String userId);

}