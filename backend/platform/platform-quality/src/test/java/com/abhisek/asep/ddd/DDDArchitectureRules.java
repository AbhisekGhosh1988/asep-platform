package com.abhisek.asep.ddd;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.abhisek.asep")
public class DDDArchitectureRules {

    @ArchTest
    static final ArchRule repositories_must_be_interfaces =
            classes()
                    .that()
                    .resideInAPackage("..domain.repository..")
                    .should()
                    .beInterfaces();

}