package com.abhisek.asep.identity.infrastructure.persistence.mapper.impl;

import com.abhisek.asep.identity.domain.model.RefreshToken;
import com.abhisek.asep.identity.infrastructure.persistence.entity.RefreshTokenEntity;
import com.abhisek.asep.identity.infrastructure.persistence.mapper.RefreshTokenPersistenceMapper;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenPersistenceMapperImpl
        implements RefreshTokenPersistenceMapper {

    @Override
    public RefreshToken toDomain(RefreshTokenEntity entity) {

        if (entity == null) {
            return null;
        }

        return RefreshToken.builder()
                .id(entity.getId())
                .token(entity.getToken())
                .userId(entity.getUserId())
                .expiryDate(entity.getExpiryDate())
                .revoked(entity.isRevoked())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    @Override
    public RefreshTokenEntity toEntity(RefreshToken model) {

        if (model == null) {
            return null;
        }

        return RefreshTokenEntity.builder()
                .id(model.getId())
                .token(model.getToken())
                .userId(model.getUserId())
                .expiryDate(model.getExpiryDate())
                .revoked(model.isRevoked())
                .createdAt(model.getCreatedAt())
                .build();
    }
}