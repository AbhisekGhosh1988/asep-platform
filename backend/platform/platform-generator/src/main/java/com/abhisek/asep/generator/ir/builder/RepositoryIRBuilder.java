package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.RepositoryIR;

import java.util.List;

public interface RepositoryIRBuilder {

    List<RepositoryIR> build(
            String aggregateId);

}