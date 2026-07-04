package com.abhisek.asep.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.abhisek.asep")
public class ApplicationRules {

    @ArchTest
    static final ArchRule application_should_not_depend_on_jpa =

            noClasses()

                    .that()

                    .resideInAPackage("..application..")

                    .should()

                    .dependOnClassesThat()

                    .resideInAPackage("jakarta.persistence..");

}