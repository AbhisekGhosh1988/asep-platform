package com.abhisek.asep.architecture.application.design.domainservice.imports.service;

import com.abhisek.asep.architecture.application.design.domainservice.imports.dto.request.DomainServiceDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.domainservice.imports.dto.response.DomainServiceDefinitionImportResponse;

public interface DomainServiceDefinitionImportService {

    DomainServiceDefinitionImportResponse importDomainService(
            DomainServiceDefinitionImportRequest request);

}