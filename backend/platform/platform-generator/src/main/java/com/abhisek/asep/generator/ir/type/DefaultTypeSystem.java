package com.abhisek.asep.generator.ir.type;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class DefaultTypeSystem
        implements TypeSystem {

    private final Map<String, TypeReference> types =
            new LinkedHashMap<>();

    @Override
    public void register(
            TypeReference type) {

        types.put(
                type.getQualifiedName(),
                type);

    }

    @Override
    public Optional<TypeReference> resolve(
            String qualifiedName) {

        return Optional.ofNullable(
                types.get(qualifiedName));

    }

    @Override
    public boolean exists(
            String qualifiedName) {

        return types.containsKey(
                qualifiedName);

    }

}