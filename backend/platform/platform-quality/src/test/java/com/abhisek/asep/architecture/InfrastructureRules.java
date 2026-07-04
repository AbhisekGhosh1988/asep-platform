package com.abhisek.asep.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.abhisek.asep")
public class InfrastructureRules {

    @ArchTest
    static final ArchRule infrastructure_should_not_access_rest =

            noClasses()

                    .that()

                    .resideInAPackage("..infrastructure..")

                    .should()

                    .dependOnClassesThat()

                    .resideInAPackage("..interfaces..");

}