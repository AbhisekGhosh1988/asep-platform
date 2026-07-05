package com.abhisek.asep.requirements.infrastructure.persistence.adapter;

import com.abhisek.asep.requirements.domain.model.RequirementVersion;
import com.abhisek.asep.requirements.domain.repository.RequirementVersionRepository;
import com.abhisek.asep.requirements.infrastructure.mapper.RequirementVersionPersistenceMapper;
import com.abhisek.asep.requirements.infrastructure.persistence.repository.JpaRequirementVersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RequirementVersionRepositoryAdapter implements RequirementVersionRepository {

    private final JpaRequirementVersionRepository repository;

    private final RequirementVersionPersistenceMapper mapper;

    @Override
    public RequirementVersion save(RequirementVersion version) {

        return mapper.toDomain(

                repository.save(

                        mapper.toEntity(version)));

    }

    @Override
    public Optional<RequirementVersion> findById(String id) {

        return repository.findById(id)

                .map(mapper::toDomain);

    }

    @Override
    public List<RequirementVersion> findByRequirementId(String requirementId) {

        return repository

                .findByRequirementIdOrderByVersionDesc(requirementId)

                .stream()

                .map(mapper::toDomain)

                .toList();

    }

    @Override
    public Optional<RequirementVersion> findByRequirementIdAndVersion(String requirementId, Integer version) {

        return repository

                .findByRequirementIdOrderByVersionDesc(requirementId)

                .stream()

                .filter(v -> v.getVersion().equals(version))

                .findFirst()

                .map(mapper::toDomain);

    }

}