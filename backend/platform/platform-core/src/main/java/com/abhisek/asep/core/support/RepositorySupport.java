package com.abhisek.asep.core.support;

import java.util.Optional;
import java.util.function.Supplier;

public final class RepositorySupport {

    private RepositorySupport() {
    }

    public static <T> T require(Optional<T> optional, Supplier<? extends RuntimeException> exceptionSupplier) {

        return optional.orElseThrow(exceptionSupplier);

    }

}