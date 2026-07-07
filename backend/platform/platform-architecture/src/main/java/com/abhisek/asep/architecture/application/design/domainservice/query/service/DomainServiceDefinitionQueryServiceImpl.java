package com.abhisek.asep.architecture.application.design.domainservice.query.service;

import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainservice.query.mapper.DomainServiceDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.repository.DomainServiceDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainServiceDefinitionQueryServiceImpl
        implements DomainServiceDefinitionQueryService {

    private final DomainServiceDefinitionRepository repository;

    private final DomainServiceDefinitionQueryMapper mapper;

    @Override
    public DomainServiceDefinitionDetailsResponse getDomainService(
            String domainServiceId) {

        return repository.findById(domainServiceId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Domain Service not found : "
                                        + domainServiceId));

    }

    @Override
    public List<DomainServiceDefinitionDetailsResponse> getDomainServices(
            String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}