package com.abhisek.asep.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.abhisek.asep")
public class ControllerRules {

    @ArchTest
    static final ArchRule controllers_should_not_access_repository =

            noClasses()

                    .that()

                    .resideInAPackage("..interfaces..")

                    .should()

                    .dependOnClassesThat()

                    .resideInAPackage("..repository..");

}