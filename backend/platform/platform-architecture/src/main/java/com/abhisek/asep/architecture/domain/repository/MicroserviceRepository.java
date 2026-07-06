package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.Microservice;

import java.util.List;
import java.util.Optional;

public interface MicroserviceRepository {

    Microservice save(Microservice microservice);

    Optional<Microservice> findById(String id);

    List<Microservice> findByBoundedContextId(String boundedContextId);

}