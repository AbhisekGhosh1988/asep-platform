package com.abhisek.asep.generator.ir.builder;

import java.util.List;

/**
 * Base class for builders that delegate
 * to multiple child builders.
 */
public abstract class CompositeIRBuilder<S, T>
        extends AbstractIRBuilder<S, T> {

    protected abstract List<IRBuilder<?, ?>> delegates();

}