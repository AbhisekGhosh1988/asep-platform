package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.RelationshipIR;

import java.util.List;

public interface RelationshipIRBuilder {

    List<RelationshipIR> build(
            String entityId);

}