package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.ArchitectureEntity;

public interface ArchitecturePersistenceMapper {

    ArchitectureEntity toEntity(
            Architecture architecture);

    Architecture toDomain(
            ArchitectureEntity entity);

}