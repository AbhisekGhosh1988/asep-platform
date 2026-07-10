package com.abhisek.asep.generator.ir.builder.policy;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.builder.domainservice.ServiceOperationIRBuilder;
import com.abhisek.asep.generator.ir.model.PolicyIR;
import com.abhisek.asep.generator.model.PolicyModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultPolicyIRBuilder extends BaseArtifactIRBuilder<PolicyModel, PolicyIR> implements PolicyIRBuilder {

    private final ServiceOperationIRBuilder serviceOperationIRBuilder;

    @Override
    protected void validate(PolicyModel source) {

        super.validate(source);

        if (source.getName() == null || source.getName().isBlank()) {

            throw new IllegalArgumentException("Policy name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {

        return "Policy";

    }

    @Override
    protected PolicyIR doBuild(PolicyModel source) {

        PolicyIR policy = PolicyIR.builder().id(source.getId()).name(source.getName()).description(source.getDescription()).build();

        source.getOperations().forEach(operation -> policy.getOperations().add(serviceOperationIRBuilder.build(operation)));

        return policy;

    }

}