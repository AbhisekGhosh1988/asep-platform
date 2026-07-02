package com.abhisek.asep.identity.infrastructure.persistence.mapper;

import com.abhisek.asep.identity.domain.model.User;
import com.abhisek.asep.identity.infrastructure.persistence.entity.UserEntity;

public interface UserPersistenceMapper {

    User toDomain(UserEntity entity);

    UserEntity toEntity(User user);

}