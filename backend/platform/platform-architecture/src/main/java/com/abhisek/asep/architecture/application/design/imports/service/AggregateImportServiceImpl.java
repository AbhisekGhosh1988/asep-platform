package com.abhisek.asep.architecture.application.design.imports.service;

import com.abhisek.asep.architecture.application.design.imports.dto.request.AggregateImportRequest;
import com.abhisek.asep.architecture.application.design.imports.dto.response.AggregateImportResponse;
import com.abhisek.asep.architecture.application.design.imports.mapper.AggregateImportMapper;
import com.abhisek.asep.architecture.domain.model.Aggregate;
import com.abhisek.asep.architecture.domain.repository.AggregateRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AggregateImportServiceImpl extends AbstractCreateUseCase implements AggregateImportService {

    private final AggregateRepository repository;

    private final AggregateImportMapper mapper;

    @Override
    public AggregateImportResponse importAggregate(AggregateImportRequest request) {

        Aggregate aggregate = mapper.toAggregate(request);

        aggregate.setId(newId());
        aggregate.setCreatedAt(now());
        aggregate.setUpdatedAt(now());
        aggregate.setCreatedBy(currentUser());
        aggregate.setUpdatedBy(currentUser());

        aggregate = repository.save(aggregate);

        return AggregateImportResponse.builder().aggregateId(aggregate.getId()).build();

    }

}