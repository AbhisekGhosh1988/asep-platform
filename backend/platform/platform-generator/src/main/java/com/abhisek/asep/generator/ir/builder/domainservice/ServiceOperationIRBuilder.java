package com.abhisek.asep.generator.ir.builder.domainservice;

import com.abhisek.asep.generator.ir.model.ServiceOperationIR;
import com.abhisek.asep.generator.model.ServiceOperationModel;

public interface ServiceOperationIRBuilder {

    ServiceOperationIR build(ServiceOperationModel source);

}