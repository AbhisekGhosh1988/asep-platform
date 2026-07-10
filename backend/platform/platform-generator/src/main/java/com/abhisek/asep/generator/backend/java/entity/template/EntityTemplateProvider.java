package com.abhisek.asep.generator.backend.java.entity.template;

import com.abhisek.asep.generator.ir.model.EntityIR;

public interface EntityTemplateProvider {

    String generate(EntityIR entity);

}