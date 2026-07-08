package com.abhisek.asep.architecture.application.design.policy.imports.service;

import com.abhisek.asep.architecture.application.design.policy.imports.dto.request.PolicyDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.policy.imports.dto.response.PolicyDefinitionImportResponse;

public interface PolicyDefinitionImportService {

    PolicyDefinitionImportResponse importPolicy(
            PolicyDefinitionImportRequest request);

}