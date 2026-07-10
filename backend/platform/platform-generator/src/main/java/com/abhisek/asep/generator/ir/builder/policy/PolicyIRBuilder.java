package com.abhisek.asep.generator.ir.builder.policy;

import com.abhisek.asep.generator.ir.model.PolicyIR;
import com.abhisek.asep.generator.model.PolicyModel;

public interface PolicyIRBuilder {

    PolicyIR build(PolicyModel source);

}