package com.abhisek.asep.architecture.application.design.domainevent.imports.service;

import com.abhisek.asep.architecture.application.design.domainevent.imports.dto.request.DomainEventDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.domainevent.imports.dto.response.DomainEventDefinitionImportResponse;

public interface DomainEventDefinitionImportService {

    DomainEventDefinitionImportResponse importDomainEvent(
            DomainEventDefinitionImportRequest request);

}