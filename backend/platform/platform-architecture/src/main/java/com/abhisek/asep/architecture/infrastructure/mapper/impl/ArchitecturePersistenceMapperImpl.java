package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.infrastructure.mapper.ArchitecturePersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.ArchitectureEntity;
import org.springframework.stereotype.Component;

@Component
public class ArchitecturePersistenceMapperImpl implements ArchitecturePersistenceMapper {

    @Override
    public ArchitectureEntity toEntity(Architecture architecture) {

        if (architecture == null) {
            return null;
        }

        return ArchitectureEntity.builder().id(architecture.getId()).projectId(architecture.getProjectId()).name(architecture.getName()).description(architecture.getDescription()).style(architecture.getStyle()).status(architecture.getStatus()).version(architecture.getVersion()).createdBy(architecture.getCreatedBy()).createdAt(architecture.getCreatedAt()).updatedBy(architecture.getUpdatedBy()).updatedAt(architecture.getUpdatedAt()).build();

    }

    @Override
    public Architecture toDomain(ArchitectureEntity entity) {

        if (entity == null) {
            return null;
        }

        return Architecture.builder().id(entity.getId()).projectId(entity.getProjectId()).name(entity.getName()).description(entity.getDescription()).style(entity.getStyle()).status(entity.getStatus()).version(entity.getVersion()).createdBy(entity.getCreatedBy()).createdAt(entity.getCreatedAt()).updatedBy(entity.getUpdatedBy()).updatedAt(entity.getUpdatedAt()).build();

    }

}