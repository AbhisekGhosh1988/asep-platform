package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.BoundedContextEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaBoundedContextRepository
        extends JpaRepository<BoundedContextEntity,String> {

    List<BoundedContextEntity> findByArchitectureId(String architectureId);

}