package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.DomainServiceIR;

import java.util.List;

public interface DomainServiceIRBuilder {

    List<DomainServiceIR> build(
            String aggregateId);

}