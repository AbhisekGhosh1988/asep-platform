package com.abhisek.asep.generator.core;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultGeneratorRegistry implements GeneratorRegistry {

    private final List<CodeGenerator> generators = new ArrayList<>();

    @Override
    public void register(CodeGenerator generator) {

        generators.add(generator);

    }

    @Override
    public List<CodeGenerator> getGenerators(GenerationType type) {

        return generators.stream().filter(generator -> generator.getGenerationType() == type).collect(Collectors.toList());

    }

    @Override
    public List<CodeGenerator> getAllGenerators() {

        return generators;

    }

}