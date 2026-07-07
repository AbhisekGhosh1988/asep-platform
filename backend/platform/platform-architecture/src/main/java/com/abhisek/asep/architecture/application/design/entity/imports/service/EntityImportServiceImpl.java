package com.abhisek.asep.architecture.application.design.entity.imports.service;

import com.abhisek.asep.architecture.application.design.entity.imports.dto.request.EntityImportRequest;
import com.abhisek.asep.architecture.application.design.entity.imports.dto.response.EntityImportResponse;
import com.abhisek.asep.architecture.application.design.entity.imports.mapper.EntityImportMapper;
import com.abhisek.asep.architecture.domain.model.Entity;
import com.abhisek.asep.architecture.domain.repository.EntityRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EntityImportServiceImpl extends AbstractCreateUseCase implements EntityImportService {

    private final EntityRepository repository;

    private final EntityImportMapper mapper;

    @Override
    public EntityImportResponse importEntity(EntityImportRequest request) {

        Entity entity = mapper.toEntity(request);

        entity.setId(newId());

        entity.setCreatedAt(now());
        entity.setUpdatedAt(now());

        entity.setCreatedBy(currentUser());
        entity.setUpdatedBy(currentUser());

        entity = repository.save(entity);

        return EntityImportResponse.builder().entityId(entity.getId()).build();

    }

}