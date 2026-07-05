package com.abhisek.asep.requirements.infrastructure.persistence.adapter;

import com.abhisek.asep.requirements.domain.model.RequirementAttachment;
import com.abhisek.asep.requirements.domain.repository.RequirementAttachmentRepository;
import com.abhisek.asep.requirements.infrastructure.persistence.mapper.RequirementAttachmentPersistenceMapper;
import com.abhisek.asep.requirements.infrastructure.persistence.repository.JpaRequirementAttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RequirementAttachmentRepositoryAdapter implements RequirementAttachmentRepository {

    private final JpaRequirementAttachmentRepository repository;
    private final RequirementAttachmentPersistenceMapper mapper;

    @Override
    public RequirementAttachment save(RequirementAttachment attachment) {

        return mapper.toDomain(repository.save(mapper.toEntity(attachment)));
    }

    @Override
    public Optional<RequirementAttachment> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<RequirementAttachment> findByRequirementId(String requirementId) {

        return repository.findByRequirementId(requirementId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(String id) {

        repository.deleteById(id);
    }
}