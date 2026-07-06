package com.abhisek.asep.architecture.application.imports.service.impl;

import com.abhisek.asep.architecture.application.imports.dto.request.ArchitectureImportRequest;
import com.abhisek.asep.architecture.application.imports.dto.request.BoundedContextImportRequest;
import com.abhisek.asep.architecture.application.imports.dto.request.MicroserviceImportRequest;
import com.abhisek.asep.architecture.application.imports.dto.response.ArchitectureImportResponse;
import com.abhisek.asep.architecture.application.imports.mapper.ArchitectureImportMapper;
import com.abhisek.asep.architecture.application.imports.service.ArchitectureImportService;
import com.abhisek.asep.architecture.domain.enums.ArchitectureStatus;
import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.domain.model.BoundedContext;
import com.abhisek.asep.architecture.domain.model.Microservice;
import com.abhisek.asep.architecture.domain.repository.ArchitectureRepository;
import com.abhisek.asep.architecture.domain.repository.BoundedContextRepository;
import com.abhisek.asep.architecture.domain.repository.MicroserviceRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArchitectureImportServiceImpl extends AbstractCreateUseCase implements ArchitectureImportService {

    private final ArchitectureRepository architectureRepository;

    private final BoundedContextRepository boundedContextRepository;

    private final MicroserviceRepository microserviceRepository;

    private final ArchitectureImportMapper mapper;

    @Override
    public ArchitectureImportResponse importArchitecture(ArchitectureImportRequest request) {
        if (architectureRepository.existsByProjectIdAndName(request.getProjectId(), request.getName())) {
            throw new IllegalArgumentException("Architecture already exists for project: " + request.getName());
        }
        Architecture architecture = mapper.toArchitecture(request);

        architecture.setId(newId());
        architecture.setCreatedAt(now());
        architecture.setUpdatedAt(now());
        architecture.setCreatedBy(currentUser());
        architecture.setUpdatedBy(currentUser());
        architecture.setStatus(ArchitectureStatus.DRAFT);
        architecture.setVersion(1);

        architecture = architectureRepository.save(architecture);

        int microserviceCount = 0;

        for (BoundedContextImportRequest contextRequest : request.getBoundedContexts()) {

            BoundedContext boundedContext = BoundedContext.builder().id(newId()).architectureId(architecture.getId()).
                    name(contextRequest.getName()).description(contextRequest.getDescription()).responsibility(contextRequest.getResponsibility()).
                    createdAt(now()).updatedAt(now()).createdBy(currentUser()).updatedBy(currentUser()).build();
            boundedContext = boundedContextRepository.save(boundedContext);
            for (MicroserviceImportRequest serviceRequest : contextRequest.getMicroservices()) {

                Microservice microservice = Microservice.builder().id(newId()).boundedContextId(boundedContext.getId()).
                        name(serviceRequest.getName()).description(serviceRequest.getDescription()).
                        style(serviceRequest.getStyle()).createdAt(now()).updatedAt(now()).createdBy(currentUser()).updatedBy(currentUser()).build();
                microserviceRepository.save(microservice);
                microserviceCount++;
            }

        }
        return ArchitectureImportResponse.builder().architectureId(architecture.getId()).
                boundedContextCount(request.getBoundedContexts().size()).microserviceCount(microserviceCount).build();

    }

}