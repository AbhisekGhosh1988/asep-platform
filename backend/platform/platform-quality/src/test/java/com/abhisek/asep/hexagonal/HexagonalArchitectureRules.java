package com.abhisek.asep.hexagonal;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.abhisek.asep")
public class HexagonalArchitectureRules {

    @ArchTest
    static final ArchRule domain_should_not_depend_on_infrastructure =

            noClasses()

                    .that()

                    .resideInAPackage("..domain..")

                    .should()

                    .dependOnClassesThat()

                    .resideInAPackage("..infrastructure..");


    @ArchTest
    static final ArchRule domain_should_not_depend_on_interfaces =

            noClasses()

                    .that()

                    .resideInAPackage("..domain..")

                    .should()

                    .dependOnClassesThat()

                    .resideInAPackage("..interfaces..");

    @ArchTest
    static final ArchRule controllers_should_not_access_infrastructure =

            noClasses()

                    .that()

                    .resideInAPackage("..interfaces..")

                    .should()

                    .dependOnClassesThat()

                    .resideInAPackage("..infrastructure..");

    @ArchTest
    static final ArchRule repository_adapter_should_implement_domain_repository =

            classes()

                    .that()

                    .haveSimpleNameEndingWith("RepositoryAdapter")

                    .should()

                    .implement(
                            JavaClass.Predicates.simpleNameEndingWith("Repository"));


    @ArchTest
    static final ArchRule controller_should_not_depend_on_service =

            noClasses()

                    .that()

                    .resideInAPackage("..interfaces.rest..")

                    .should()

                    .dependOnClassesThat()

                    .resideInAPackage("..application.service..");

}