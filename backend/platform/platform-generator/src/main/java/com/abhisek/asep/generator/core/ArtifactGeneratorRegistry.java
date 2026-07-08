package com.abhisek.asep.generator.core;

import com.abhisek.asep.generator.model.ArtifactType;

import java.util.List;

public interface ArtifactGeneratorRegistry {

    void register(ArtifactGenerator generator);

    ArtifactGenerator getGenerator(ArtifactType type);

    List<ArtifactGenerator> getAll();

}