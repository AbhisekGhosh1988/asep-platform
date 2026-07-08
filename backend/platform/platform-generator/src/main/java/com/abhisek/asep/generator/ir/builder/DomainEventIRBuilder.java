package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.DomainEventIR;

import java.util.List;

public interface DomainEventIRBuilder {

    List<DomainEventIR> build(
            String aggregateId);

}