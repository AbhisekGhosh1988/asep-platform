package com.abhisek.asep.architecture.application.design.policy.query.service;

import com.abhisek.asep.architecture.application.design.policy.query.dto.PolicyDefinitionDetailsResponse;

import java.util.List;

public interface PolicyDefinitionQueryService {

    PolicyDefinitionDetailsResponse getPolicy(
            String policyId);

    List<PolicyDefinitionDetailsResponse> getPolicies(
            String aggregateId);

}