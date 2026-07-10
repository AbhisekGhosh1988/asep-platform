package com.abhisek.asep.generator.backend.spi;

import java.util.Optional;

/**
 * Registry of backend artifact generators.
 */
public interface GeneratorRegistry {

    /**
     * Returns the generator responsible for the supplied artifact type.
     */
    Optional<ArtifactGenerator> find(
            ArtifactType artifactType);

}