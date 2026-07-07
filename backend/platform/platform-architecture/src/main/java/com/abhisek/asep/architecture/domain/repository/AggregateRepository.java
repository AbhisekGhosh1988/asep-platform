package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.Aggregate;

import java.util.List;
import java.util.Optional;

public interface AggregateRepository {

    Aggregate save(Aggregate aggregate);

    Optional<Aggregate> findById(String id);

    List<Aggregate> findByMicroserviceId(String microserviceId);

}