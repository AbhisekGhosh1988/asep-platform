package com.abhisek.asep.project.infrastructure.persistence.adapter;

import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import com.abhisek.asep.project.infrastructure.persistence.mapper.ProjectPersistenceMapper;
import com.abhisek.asep.project.infrastructure.persistence.repository.JpaProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectRepositoryAdapter implements ProjectRepository {

    private final JpaProjectRepository repository;
    private final ProjectPersistenceMapper mapper;

    @Override
    public Project save(Project project) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(project)
                )
        );
    }

    @Override
    public Optional<Project> findById(String id) {

        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Project> findByName(String name) {

        return repository.findByName(name)
                .map(mapper::toDomain);
    }

    @Override
    public List<Project> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByName(String name) {

        return repository.existsByName(name);
    }

    @Override
    public void deleteById(String id) {

        repository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {

        return repository.existsById(id);

    }
}