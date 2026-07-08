package com.abhisek.asep.architecture.application.design.policy.query.service;

import com.abhisek.asep.architecture.application.design.policy.query.dto.PolicyDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.policy.query.mapper.PolicyDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.repository.PolicyDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyDefinitionQueryServiceImpl
        implements PolicyDefinitionQueryService {

    private final PolicyDefinitionRepository repository;
    private final PolicyDefinitionQueryMapper mapper;

    @Override
    public PolicyDefinitionDetailsResponse getPolicy(
            String policyId) {

        return repository.findById(policyId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Policy not found : " + policyId));
    }

    @Override
    public List<PolicyDefinitionDetailsResponse> getPolicies(
            String aggregateId) {

        return repository.findByAggregateId(aggregateId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}