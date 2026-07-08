package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.ApiContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaApiContractRepository extends JpaRepository<ApiContractEntity, String> {

    List<ApiContractEntity> findByAggregateId(String aggregateId);

    boolean existsByAggregateIdAndName(String aggregateId, String name);

}