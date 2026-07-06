package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.MicroserviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMicroserviceRepository
        extends JpaRepository<MicroserviceEntity,String> {

    List<MicroserviceEntity> findByBoundedContextId(String boundedContextId);

}