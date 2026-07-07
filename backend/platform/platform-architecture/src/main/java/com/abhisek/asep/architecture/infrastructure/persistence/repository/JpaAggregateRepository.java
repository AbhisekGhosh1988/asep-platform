package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.AggregateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAggregateRepository
        extends JpaRepository<AggregateEntity, String> {

    List<AggregateEntity> findByMicroserviceId(String microserviceId);

}