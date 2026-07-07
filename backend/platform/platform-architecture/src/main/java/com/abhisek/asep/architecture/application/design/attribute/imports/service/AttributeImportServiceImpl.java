package com.abhisek.asep.architecture.application.design.attribute.imports.service;

import com.abhisek.asep.architecture.application.design.attribute.imports.dto.request.AttributeImportRequest;
import com.abhisek.asep.architecture.application.design.attribute.imports.dto.response.AttributeImportResponse;
import com.abhisek.asep.architecture.application.design.attribute.imports.mapper.AttributeImportMapper;
import com.abhisek.asep.architecture.domain.model.Attribute;

import com.abhisek.asep.architecture.domain.repository.AttributeRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AttributeImportServiceImpl
        extends AbstractCreateUseCase
        implements AttributeImportService {

    private final AttributeRepository repository;

    private final AttributeImportMapper mapper;

    @Override
    public AttributeImportResponse importAttribute(
            AttributeImportRequest request) {

        Attribute attribute =
                mapper.toAttribute(request);

        attribute.setId(newId());

        attribute.setCreatedAt(now());
        attribute.setUpdatedAt(now());

        attribute.setCreatedBy(currentUser());
        attribute.setUpdatedBy(currentUser());

        attribute = repository.save(attribute);

        return AttributeImportResponse.builder()
                .attributeId(attribute.getId())
                .build();

    }

}