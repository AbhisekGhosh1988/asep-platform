package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAttributeRepository
        extends JpaRepository<AttributeEntity,String> {

    List<AttributeEntity> findByEntityId(String entityId);

}