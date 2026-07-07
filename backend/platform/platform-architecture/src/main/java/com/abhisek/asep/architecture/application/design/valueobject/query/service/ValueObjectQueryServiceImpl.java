package com.abhisek.asep.architecture.application.design.valueobject.query.service;

import com.abhisek.asep.architecture.application.design.valueobject.query.dto.ValueObjectDetailsResponse;
import com.abhisek.asep.architecture.application.design.valueobject.query.mapper.ValueObjectQueryMapper;
import com.abhisek.asep.architecture.domain.repository.ValueObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValueObjectQueryServiceImpl implements ValueObjectQueryService {

    private final ValueObjectRepository repository;

    private final ValueObjectQueryMapper mapper;

    @Override
    public ValueObjectDetailsResponse getValueObject(String valueObjectId) {

        return repository.findById(valueObjectId).map(mapper::toResponse).orElseThrow(() -> new IllegalArgumentException("Value Object not found : " + valueObjectId));

    }

    @Override
    public List<ValueObjectDetailsResponse> getValueObjects(String aggregateId) {

        return repository.findByAggregateId(aggregateId).stream().map(mapper::toResponse).toList();

    }

}