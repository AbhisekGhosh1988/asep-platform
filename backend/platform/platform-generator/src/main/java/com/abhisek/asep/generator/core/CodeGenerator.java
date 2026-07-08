package com.abhisek.asep.generator.core;

import com.abhisek.asep.generator.api.GenerationResult;

public interface CodeGenerator {

    GenerationType getGenerationType();

    GenerationResult generate(
            GenerationContext context);

}