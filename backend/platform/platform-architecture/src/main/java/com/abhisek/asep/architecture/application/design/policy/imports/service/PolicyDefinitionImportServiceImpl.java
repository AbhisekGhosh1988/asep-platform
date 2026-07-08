package com.abhisek.asep.architecture.application.design.policy.imports.service;

import com.abhisek.asep.architecture.application.design.policy.imports.dto.request.PolicyDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.policy.imports.dto.response.PolicyDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.policy.imports.mapper.PolicyDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.PolicyDefinition;
import com.abhisek.asep.architecture.domain.repository.PolicyDefinitionRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PolicyDefinitionImportServiceImpl
        extends AbstractCreateUseCase
        implements PolicyDefinitionImportService {

    private final PolicyDefinitionRepository repository;
    private final PolicyDefinitionImportMapper mapper;

    @Override
    public PolicyDefinitionImportResponse importPolicy(
            PolicyDefinitionImportRequest request) {

        if (repository.existsByAggregateIdAndName(
                request.getAggregateId(),
                request.getName())) {

            throw new IllegalArgumentException(
                    "Policy already exists.");
        }

        PolicyDefinition policy =
                mapper.toPolicy(request);

        policy.setId(newId());
        policy.setCreatedAt(now());
        policy.setUpdatedAt(now());
        policy.setCreatedBy(currentUser());
        policy.setUpdatedBy(currentUser());

        policy = repository.save(policy);

        return PolicyDefinitionImportResponse.builder()
                .policyId(policy.getId())
                .build();
    }
}