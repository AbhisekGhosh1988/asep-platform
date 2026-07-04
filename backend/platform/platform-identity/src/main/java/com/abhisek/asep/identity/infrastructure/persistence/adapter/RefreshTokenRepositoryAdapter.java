package com.abhisek.asep.identity.infrastructure.persistence.adapter;

import com.abhisek.asep.identity.domain.model.RefreshToken;
import com.abhisek.asep.identity.domain.repository.RefreshTokenRepository;
import com.abhisek.asep.identity.infrastructure.persistence.mapper.RefreshTokenPersistenceMapper;
import com.abhisek.asep.identity.infrastructure.persistence.repository.JpaRefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepositoryAdapter implements RefreshTokenRepository {

    private final JpaRefreshTokenRepository repository;
    private final RefreshTokenPersistenceMapper mapper;

    @Override
    public RefreshToken save(RefreshToken token) {
        return mapper.toDomain(repository.save(mapper.toEntity(token)));
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return repository.findByToken(token).map(mapper::toDomain);
    }

    @Override
    public void deleteByUserId(String userId) {
        repository.deleteByUserId(userId);
    }
}