package com.abhisek.asep.generator.ir.builder.repository;

import com.abhisek.asep.generator.ir.model.RepositoryMethodIR;
import com.abhisek.asep.generator.model.RepositoryMethodModel;

public interface RepositoryMethodIRBuilder {

    RepositoryMethodIR build(
            RepositoryMethodModel source);

}