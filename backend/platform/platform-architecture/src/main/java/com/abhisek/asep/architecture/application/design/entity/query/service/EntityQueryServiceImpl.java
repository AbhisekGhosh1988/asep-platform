package com.abhisek.asep.architecture.application.design.entity.query.service;

import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.mapper.EntityQueryMapper;
import com.abhisek.asep.architecture.domain.repository.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntityQueryServiceImpl
        implements EntityQueryService {

    private final EntityRepository repository;

    private final EntityQueryMapper mapper;

    @Override
    public EntityDetailsResponse getEntity(String entityId) {

        return repository.findById(entityId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Entity not found : " + entityId));

    }

    @Override
    public List<EntityDetailsResponse> getEntities(String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}