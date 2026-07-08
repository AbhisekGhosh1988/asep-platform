package com.abhisek.asep.generator.ir.type;

import java.util.Optional;

public interface TypeSystem {

    void register(
            TypeReference type);

    Optional<TypeReference> resolve(
            String qualifiedName);

    boolean exists(
            String qualifiedName);

}