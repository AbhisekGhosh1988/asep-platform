package com.abhisek.asep.generator.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultGeneratorFactory implements GeneratorFactory {

    private final GeneratorRegistry registry;

    @Override
    public CodeGenerator getGenerator(GenerationType type) {

        return registry.getGenerators(type).stream().findFirst().orElseThrow(() -> new GeneratorException("No generator registered for " + type));

    }

}