package com.abhisek.asep.requirements.application.service.impl;

import com.abhisek.asep.core.support.RepositorySupport;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.dto.response.RequirementSummaryResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementQueryService;
import com.abhisek.asep.requirements.domain.exception.RequirementNotFoundException;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.repository.RequirementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RequirementQueryServiceImpl implements RequirementQueryService {

    private final RequirementRepository repository;

    private final RequirementApplicationMapper mapper;

    @Override
    public RequirementResponse getById(String requirementId) {

        Requirement requirement = RepositorySupport.require(

                repository.findById(requirementId),

                () -> new RequirementNotFoundException("Requirement not found"));

        return mapper.toResponse(requirement);

    }

    @Override
    public List<RequirementSummaryResponse> list(String projectId) {

        return repository.findByProjectId(projectId)

                .stream()

                .map(mapper::toSummary)

                .toList();

    }

}