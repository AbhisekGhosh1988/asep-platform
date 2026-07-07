package com.abhisek.asep.architecture.application.design.relationship.imports.service;

import com.abhisek.asep.architecture.application.design.relationship.imports.dto.request.RelationshipImportRequest;
import com.abhisek.asep.architecture.application.design.relationship.imports.dto.response.RelationshipImportResponse;
import com.abhisek.asep.architecture.application.design.relationship.imports.mapper.RelationshipImportMapper;
import com.abhisek.asep.architecture.domain.model.Relationship;
import com.abhisek.asep.architecture.domain.repository.RelationshipRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RelationshipImportServiceImpl
        extends AbstractCreateUseCase
        implements RelationshipImportService {

    private final RelationshipRepository repository;

    private final RelationshipImportMapper mapper;

    @Override
    public RelationshipImportResponse importRelationship(
            RelationshipImportRequest request) {

        if (repository.existsBySourceEntityIdAndTargetEntityIdAndFieldName(
                request.getSourceEntityId(),
                request.getTargetEntityId(),
                request.getFieldName())) {

            throw new IllegalArgumentException(
                    "Relationship already exists.");
        }

        Relationship relationship =
                mapper.toRelationship(request);

        relationship.setId(newId());

        relationship.setCreatedAt(now());
        relationship.setUpdatedAt(now());

        relationship.setCreatedBy(currentUser());
        relationship.setUpdatedBy(currentUser());

        relationship = repository.save(relationship);

        return RelationshipImportResponse.builder()
                .relationshipId(relationship.getId())
                .build();
    }
}