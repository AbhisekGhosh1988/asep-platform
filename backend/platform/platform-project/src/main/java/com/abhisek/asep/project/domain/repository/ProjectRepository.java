package com.abhisek.asep.project.domain.repository;

import com.abhisek.asep.project.domain.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    Project save(Project project);

    Optional<Project> findById(String id);

    Optional<Project> findByName(String name);

    List<Project> findAll();

    boolean existsByName(String name);

    void deleteById(String id);

    boolean existsById(String id);

}