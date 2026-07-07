package com.abhisek.asep.architecture.application.design.query.service;

import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.mapper.AggregateQueryMapper;
import com.abhisek.asep.architecture.domain.repository.AggregateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AggregateQueryServiceImpl implements AggregateQueryService {

    private final AggregateRepository repository;

    private final AggregateQueryMapper mapper;

    @Override
    public AggregateDetailsResponse getAggregate(String aggregateId) {

        return repository.findById(aggregateId).map(mapper::toResponse).orElseThrow(() -> new IllegalArgumentException("Aggregate not found : " + aggregateId));

    }

    @Override
    public List<AggregateDetailsResponse> getAggregates(String microserviceId) {

        return repository.findByMicroserviceId(microserviceId).stream().map(mapper::toResponse).toList();

    }

}