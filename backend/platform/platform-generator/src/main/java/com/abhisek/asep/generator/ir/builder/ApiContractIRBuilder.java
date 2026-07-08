package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.ApiContractIR;

import java.util.List;

public interface ApiContractIRBuilder {

    List<ApiContractIR> build(
            String aggregateId);

}