package com.abhisek.asep.generator.backend.spi;

import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class DefaultGeneratorRegistry
        implements GeneratorRegistry {

    private final Map<ArtifactType, ArtifactGenerator> generators =
            new EnumMap<>(ArtifactType.class);

    public DefaultGeneratorRegistry(
            List<ArtifactGenerator> generators) {

        for (ArtifactGenerator generator : generators) {

            this.generators.put(
                    generator.getArtifactType(),
                    generator);

        }

    }

    @Override
    public Optional<ArtifactGenerator> find(
            ArtifactType artifactType) {

        return Optional.ofNullable(
                generators.get(artifactType));

    }

}