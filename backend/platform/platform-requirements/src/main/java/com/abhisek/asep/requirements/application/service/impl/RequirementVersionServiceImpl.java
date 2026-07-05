package com.abhisek.asep.requirements.application.service.impl;


import com.abhisek.asep.core.support.RepositorySupport;
import com.abhisek.asep.core.support.diff.DiffResult;
import com.abhisek.asep.core.support.diff.ObjectDiffUtil;
import com.abhisek.asep.requirements.application.dto.response.FieldDifferenceResponse;
import com.abhisek.asep.requirements.application.dto.response.RequirementVersionComparisonResponse;
import com.abhisek.asep.requirements.application.service.RequirementVersionService;
import com.abhisek.asep.requirements.domain.exception.RequirementVersionException;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementVersion;
import com.abhisek.asep.requirements.domain.repository.RequirementRepository;
import com.abhisek.asep.requirements.domain.repository.RequirementVersionRepository;
import com.abhisek.asep.requirements.domain.snapshot.RequirementSnapshot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class RequirementVersionServiceImpl implements RequirementVersionService {
    private final RequirementVersionRepository versionRepository;
    private final RequirementRepository requirementRepository;
    private final ObjectMapper objectMapper;

    @Override
    @Transactional
    public void createVersion(Requirement requirement) {

        try {
            RequirementVersion version = RequirementVersion.builder().id(UUID.randomUUID().toString()).
                    requirementId(requirement.getId()).version(requirement.getVersion()).
                    snapshot(objectMapper.writeValueAsString(requirement)).createdBy(requirement.getUpdatedBy()).
                    createdAt(Instant.now()).build();
            versionRepository.save(version);
        } catch (JsonProcessingException e) {
            throw new RequirementVersionException("Unable to create requirement version", e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<RequirementVersion> history(String requirementId) {
        return versionRepository.findByRequirementId(requirementId);

    }

    @Override
    @Transactional(readOnly = true)
    public RequirementVersion getVersion(String requirementId, Integer version) {
        return RepositorySupport.require(versionRepository.findByRequirementIdAndVersion(requirementId, version),
                () -> new RequirementVersionException("Version not found"));

    }

    @Transactional
    @Override
    public Requirement restore(String requirementId, Integer version) {

        RequirementVersion requirementVersion = getVersion(requirementId, version);
        try {
            Requirement restored = objectMapper.readValue(requirementVersion.getSnapshot(), Requirement.class);
            restored.setVersion(restored.getVersion() + 1);
            restored.setUpdatedAt(Instant.now());
            Requirement saved = requirementRepository.save(restored);
            createVersion(saved);
            return saved;
        } catch (Exception e) {
            throw new RequirementVersionException("Unable to restore version", e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public RequirementVersionComparisonResponse compare(String requirementId, Integer sourceVersion,
                                                        Integer targetVersion) {

        RequirementVersion source = getVersion(requirementId, sourceVersion);
        RequirementVersion target = getVersion(requirementId, targetVersion);
        try {

            RequirementSnapshot sourceSnapshot = objectMapper.readValue(source.getSnapshot(), RequirementSnapshot.class);
            RequirementSnapshot targetSnapshot = objectMapper.readValue(target.getSnapshot(), RequirementSnapshot.class);
            DiffResult diffResult = ObjectDiffUtil.compare(sourceSnapshot, targetSnapshot);
            List<FieldDifferenceResponse> differences = diffResult.getDifferences().stream().map(diff -> FieldDifferenceResponse.builder().field(diff.getField()).oldValue(diff.getOldValue()).newValue(diff.getNewValue()).build()).toList();
            return RequirementVersionComparisonResponse.builder().sourceVersion(sourceVersion).targetVersion(targetVersion).differences(differences).build();
        } catch (Exception ex) {
            throw new RequirementVersionException("Unable to compare requirement versions", ex);
        }
    }
}
