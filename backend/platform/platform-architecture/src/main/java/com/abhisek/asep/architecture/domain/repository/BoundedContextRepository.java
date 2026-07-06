package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.BoundedContext;

import java.util.List;
import java.util.Optional;

public interface BoundedContextRepository {

    BoundedContext save(BoundedContext boundedContext);

    Optional<BoundedContext> findById(String id);

    List<BoundedContext> findByArchitectureId(String architectureId);

}