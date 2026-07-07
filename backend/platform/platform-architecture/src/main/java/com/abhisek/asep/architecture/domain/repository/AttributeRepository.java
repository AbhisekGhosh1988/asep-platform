package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.Attribute;

import java.util.List;
import java.util.Optional;

public interface AttributeRepository {

    Attribute save(Attribute attribute);

    Optional<Attribute> findById(String id);

    List<Attribute> findByEntityId(String entityId);

}