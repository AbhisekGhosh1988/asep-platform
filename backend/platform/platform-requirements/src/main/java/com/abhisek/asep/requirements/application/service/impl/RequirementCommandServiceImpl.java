package com.abhisek.asep.requirements.application.service.impl;

import com.abhisek.asep.core.domain.event.DomainEventPublisher;
import com.abhisek.asep.core.support.RepositorySupport;
import com.abhisek.asep.requirements.application.dto.request.*;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementCommandService;
import com.abhisek.asep.requirements.application.service.RequirementVersionService;
import com.abhisek.asep.requirements.domain.enums.RequirementStatus;
import com.abhisek.asep.requirements.domain.event.*;
import com.abhisek.asep.requirements.domain.exception.*;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.repository.RequirementRepository;
import com.abhisek.asep.requirements.domain.service.RequirementDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RequirementCommandServiceImpl implements RequirementCommandService {

    private final RequirementRepository repository;
    private final RequirementApplicationMapper mapper;
    private final RequirementDomainService domainService;
    private final DomainEventPublisher eventPublisher;
    private final RequirementVersionService versionService;
    @Override
    public RequirementResponse create(String projectId, CreateRequirementRequest request) {

        if (repository.existsByProjectIdAndTitle(projectId, request.getTitle())) {
            throw new DuplicateRequirementException("Requirement already exists: " + request.getTitle());
        }

        Requirement requirement = mapper.toDomain(request);

        requirement.setId(UUID.randomUUID().toString());
        requirement.setProjectId(projectId);
        requirement.setStatus(RequirementStatus.DRAFT);
        requirement.setVersion(1);
        requirement.setCreatedAt(Instant.now());
        requirement.setUpdatedAt(Instant.now());

        domainService.validateCreate(requirement);

        Requirement saved = repository.save(requirement);

        eventPublisher.publish(new RequirementCreatedEvent(saved.getId(), saved.getProjectId(), Instant.now()));

        return mapper.toResponse(saved);
    }

    @Override
    public RequirementResponse update(String requirementId, UpdateRequirementRequest request) {

        Requirement requirement = RepositorySupport.require(repository.findById(requirementId), () -> new RequirementNotFoundException("Requirement not found"));

        mapper.updateDomain(requirement, request);

        requirement.setUpdatedAt(Instant.now());

        domainService.validateUpdate(requirement);
        requirement.setVersion(
                requirement.getVersion() + 1);

        Requirement saved = repository.save(requirement);
        versionService.createVersion(saved);

        eventPublisher.publish(new RequirementUpdatedEvent(saved.getId(), saved.getProjectId(), Instant.now()));

        return mapper.toResponse(saved);
    }

    @Override
    public RequirementResponse approve(String requirementId, ApproveRequirementRequest request) {

        Requirement requirement = RepositorySupport.require(repository.findById(requirementId), () -> new RequirementNotFoundException("Requirement not found"));

        domainService.validateApprove(requirement);

        requirement.setStatus(RequirementStatus.APPROVED);
        requirement.setApprovedBy(request.getApprovedBy());
        requirement.setUpdatedAt(Instant.now());

        Requirement saved = repository.save(requirement);

        eventPublisher.publish(new RequirementApprovedEvent(saved.getId(), saved.getProjectId(), saved.getApprovedBy(), Instant.now()));

        return mapper.toResponse(saved);
    }

    @Override
    public RequirementResponse reject(String requirementId, RejectRequirementRequest request) {

        Requirement requirement = RepositorySupport.require(repository.findById(requirementId), () -> new RequirementNotFoundException("Requirement not found"));

        domainService.validateReject(requirement);

        requirement.setStatus(RequirementStatus.REJECTED);
        requirement.setUpdatedAt(Instant.now());

        Requirement saved = repository.save(requirement);

        eventPublisher.publish(new RequirementRejectedEvent(saved.getId(), saved.getProjectId(), request.getReason(), Instant.now()));

        return mapper.toResponse(saved);
    }

    @Override
    public void delete(String requirementId) {

        Requirement requirement = RepositorySupport.require(repository.findById(requirementId), () -> new RequirementNotFoundException("Requirement not found"));

        repository.deleteById(requirementId);

        eventPublisher.publish(new RequirementDeletedEvent(requirement.getId(), requirement.getProjectId(), Instant.now()));
    }
}