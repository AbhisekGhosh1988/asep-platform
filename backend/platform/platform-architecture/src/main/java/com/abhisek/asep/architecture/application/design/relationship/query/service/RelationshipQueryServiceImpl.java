package com.abhisek.asep.architecture.application.design.relationship.query.service;

import com.abhisek.asep.architecture.application.design.relationship.query.dto.RelationshipDetailsResponse;
import com.abhisek.asep.architecture.application.design.relationship.query.mapper.RelationshipQueryMapper;
import com.abhisek.asep.architecture.domain.repository.RelationshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelationshipQueryServiceImpl
        implements RelationshipQueryService {

    private final RelationshipRepository repository;

    private final RelationshipQueryMapper mapper;

    @Override
    public RelationshipDetailsResponse getRelationship(
            String relationshipId) {

        return repository.findById(relationshipId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Relationship not found : " + relationshipId));

    }

    @Override
    public List<RelationshipDetailsResponse> getRelationships(
            String sourceEntityId) {

        return repository.findBySourceEntityId(sourceEntityId)
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

}