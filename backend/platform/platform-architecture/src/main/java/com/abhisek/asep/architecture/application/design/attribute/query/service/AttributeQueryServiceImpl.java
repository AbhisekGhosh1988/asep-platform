package com.abhisek.asep.architecture.application.design.attribute.query.service;

import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.mapper.AttributeQueryMapper;
import com.abhisek.asep.architecture.domain.repository.AttributeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttributeQueryServiceImpl
        implements AttributeQueryService {

    private final AttributeRepository repository;

    private final AttributeQueryMapper mapper;

    @Override
    public AttributeDetailsResponse getAttribute(
            String attributeId) {

        return repository.findById(attributeId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Attribute not found : " + attributeId));

    }

    @Override
    public List<AttributeDetailsResponse> getAttributes(
            String entityId) {

        return repository.findByEntityId(entityId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}