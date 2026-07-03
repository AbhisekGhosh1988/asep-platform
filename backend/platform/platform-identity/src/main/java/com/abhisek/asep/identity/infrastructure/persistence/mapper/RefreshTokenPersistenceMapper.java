package com.abhisek.asep.identity.infrastructure.persistence.mapper;

import com.abhisek.asep.identity.domain.model.RefreshToken;
import com.abhisek.asep.identity.infrastructure.persistence.entity.RefreshTokenEntity;

public interface RefreshTokenPersistenceMapper {

    RefreshToken toDomain(RefreshTokenEntity entity);

    RefreshTokenEntity toEntity(RefreshToken model);

}