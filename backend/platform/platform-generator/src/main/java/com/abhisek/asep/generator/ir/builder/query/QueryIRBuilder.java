package com.abhisek.asep.generator.ir.builder.query;

import com.abhisek.asep.generator.ir.model.QueryIR;
import com.abhisek.asep.generator.model.QueryModel;

public interface QueryIRBuilder {

    QueryIR build(QueryModel source);

}