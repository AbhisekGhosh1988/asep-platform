package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.domain.repository.ArchitectureRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.ArchitecturePersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaArchitectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ArchitectureRepositoryAdapter implements ArchitectureRepository {

    private final JpaArchitectureRepository repository;

    private final ArchitecturePersistenceMapper mapper;

    @Override
    public Architecture save(Architecture architecture) {

        return mapper.toDomain(repository.save(mapper.toEntity(architecture)));

    }

    @Override
    public Optional<Architecture> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<Architecture> findByProjectId(String projectId) {

        return repository.findByProjectId(projectId).stream().map(mapper::toDomain).toList();

    }

    @Override
    public boolean existsByProjectIdAndName(String projectId, String name) {

        return repository.existsByProjectIdAndName(projectId, name);

    }

    @Override
    public void deleteById(String id) {

        repository.deleteById(id);

    }

}