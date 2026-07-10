package com.abhisek.asep.generator.ir.type;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Compiler type registry.
 */
public class TypeRegistry {

    private final Map<String, Type> types =
            new LinkedHashMap<>();

    public void register(Type type) {

        types.put(type.getName(), type);

    }

    public Optional<Type> resolve(String name) {

        return Optional.ofNullable(types.get(name));

    }

    public Collection<Type> types() {

        return Collections.unmodifiableCollection(types.values());

    }

}