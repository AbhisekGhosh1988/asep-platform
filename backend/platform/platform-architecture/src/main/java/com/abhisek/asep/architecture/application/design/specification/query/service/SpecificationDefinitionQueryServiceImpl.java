package com.abhisek.asep.architecture.application.design.specification.query.service;

import com.abhisek.asep.architecture.application.design.specification.query.dto.SpecificationDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.specification.query.mapper.SpecificationDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.repository.SpecificationDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificationDefinitionQueryServiceImpl
        implements SpecificationDefinitionQueryService {

    private final SpecificationDefinitionRepository repository;

    private final SpecificationDefinitionQueryMapper mapper;

    @Override
    public SpecificationDefinitionDetailsResponse getSpecification(
            String specificationId) {

        return repository.findById(specificationId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Specification not found : "
                                        + specificationId));

    }

    @Override
    public List<SpecificationDefinitionDetailsResponse> getSpecifications(
            String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}