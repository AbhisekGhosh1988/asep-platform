package com.abhisek.asep.identity.infrastructure.persistence.repository;

import com.abhisek.asep.identity.infrastructure.persistence.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRefreshTokenRepository
        extends JpaRepository<RefreshTokenEntity, String> {

    Optional<RefreshTokenEntity> findByToken(String token);

    void deleteByUserId(String userId);

}