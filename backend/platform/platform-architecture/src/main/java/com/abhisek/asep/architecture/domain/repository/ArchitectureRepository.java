package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.Architecture;

import java.util.List;
import java.util.Optional;

public interface ArchitectureRepository {

    Architecture save(Architecture architecture);

    Optional<Architecture> findById(String id);

    List<Architecture> findByProjectId(String projectId);

    boolean existsByProjectIdAndName(String projectId, String name);

    void deleteById(String id);

}