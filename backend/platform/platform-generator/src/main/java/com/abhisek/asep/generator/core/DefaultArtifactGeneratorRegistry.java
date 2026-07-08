package com.abhisek.asep.generator.core;

import com.abhisek.asep.generator.model.ArtifactType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultArtifactGeneratorRegistry implements ArtifactGeneratorRegistry {

    private final Map<ArtifactType, ArtifactGenerator> generators = new HashMap<>();

    @Override
    public void register(ArtifactGenerator generator) {

        generators.put(generator.getArtifactType(), generator);

    }

    @Override
    public ArtifactGenerator getGenerator(ArtifactType type) {

        return generators.get(type);

    }

    @Override
    public List<ArtifactGenerator> getAll() {

        return List.copyOf(generators.values());

    }

}