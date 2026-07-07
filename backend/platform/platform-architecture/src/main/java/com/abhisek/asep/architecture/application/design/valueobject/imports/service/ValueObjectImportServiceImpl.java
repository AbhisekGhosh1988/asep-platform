package com.abhisek.asep.architecture.application.design.valueobject.imports.service;

import com.abhisek.asep.architecture.application.design.valueobject.imports.dto.request.ValueObjectImportRequest;
import com.abhisek.asep.architecture.application.design.valueobject.imports.dto.response.ValueObjectImportResponse;
import com.abhisek.asep.architecture.application.design.valueobject.imports.mapper.ValueObjectImportMapper;
import com.abhisek.asep.architecture.domain.model.ValueObject;
import com.abhisek.asep.architecture.domain.repository.ValueObjectRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ValueObjectImportServiceImpl extends AbstractCreateUseCase implements ValueObjectImportService {

    private final ValueObjectRepository repository;

    private final ValueObjectImportMapper mapper;

    @Override
    public ValueObjectImportResponse importValueObject(ValueObjectImportRequest request) {

        if (repository.existsByAggregateIdAndName(request.getAggregateId(), request.getName())) {

            throw new IllegalArgumentException("Value Object already exists.");

        }

        ValueObject valueObject = mapper.toValueObject(request);

        valueObject.setId(newId());

        valueObject.setCreatedAt(now());
        valueObject.setUpdatedAt(now());

        valueObject.setCreatedBy(currentUser());
        valueObject.setUpdatedBy(currentUser());

        valueObject = repository.save(valueObject);

        return ValueObjectImportResponse.builder().valueObjectId(valueObject.getId()).build();

    }

}