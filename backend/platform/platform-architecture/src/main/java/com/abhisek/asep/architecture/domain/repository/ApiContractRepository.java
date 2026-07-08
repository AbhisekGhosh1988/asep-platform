package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.ApiContract;

import java.util.List;
import java.util.Optional;

public interface ApiContractRepository {

    ApiContract save(
            ApiContract apiContract);

    Optional<ApiContract> findById(
            String id);

    List<ApiContract> findByAggregateId(
            String aggregateId);

    boolean existsByAggregateIdAndName(
            String aggregateId,
            String name);

}