package com.abhisek.asep.generator.core;

public interface GeneratorFactory {

    CodeGenerator getGenerator(
            GenerationType type);

}