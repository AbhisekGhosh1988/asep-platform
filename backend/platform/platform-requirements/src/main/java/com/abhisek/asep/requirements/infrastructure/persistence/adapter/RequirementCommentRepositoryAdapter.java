package com.abhisek.asep.requirements.infrastructure.persistence.adapter;

import com.abhisek.asep.requirements.domain.model.RequirementComment;
import com.abhisek.asep.requirements.domain.repository.RequirementCommentRepository;
import com.abhisek.asep.requirements.infrastructure.persistence.mapper.RequirementCommentPersistenceMapper;
import com.abhisek.asep.requirements.infrastructure.persistence.repository.JpaRequirementCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RequirementCommentRepositoryAdapter implements RequirementCommentRepository {

    private final JpaRequirementCommentRepository repository;

    private final RequirementCommentPersistenceMapper mapper;

    @Override
    public RequirementComment save(RequirementComment comment) {

        return mapper.toDomain(repository.save(mapper.toEntity(comment)));
    }

    @Override
    public List<RequirementComment> findByRequirementId(String requirementId) {

        return repository.findByRequirementId(requirementId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public Optional<RequirementComment> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void delete(String id) {

        repository.deleteById(id);
    }
}