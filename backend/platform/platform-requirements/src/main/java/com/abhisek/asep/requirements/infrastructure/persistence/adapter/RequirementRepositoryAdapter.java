package com.abhisek.asep.requirements.infrastructure.persistence.adapter;

import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.repository.RequirementRepository;
import com.abhisek.asep.requirements.infrastructure.mapper.RequirementPersistenceMapper;
import com.abhisek.asep.requirements.infrastructure.persistence.repository.JpaRequirementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RequirementRepositoryAdapter implements RequirementRepository {

    private final JpaRequirementRepository repository;

    private final RequirementPersistenceMapper mapper;

    @Override
    public Requirement save(Requirement requirement) {

        return mapper.toDomain(

                repository.save(

                        mapper.toEntity(requirement)));

    }

    @Override
    public Optional<Requirement> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<Requirement> findByProjectId(String projectId) {

        return repository.findByProjectId(projectId)

                .stream()

                .map(mapper::toDomain)

                .toList();

    }

    @Override
    public boolean existsByProjectIdAndTitle(String projectId, String title) {

        return repository.existsByProjectIdAndTitle(projectId, title);

    }

    @Override
    public void deleteById(String id) {

        repository.deleteById(id);

    }

}