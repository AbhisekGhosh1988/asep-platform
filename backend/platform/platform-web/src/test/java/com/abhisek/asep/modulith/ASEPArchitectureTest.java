package com.abhisek.asep.modulith;

import com.abhisek.asep.web.AsepApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest(classes = AsepApplication.class)
class ASEPArchitectureTest {

    @Test
    void verifyModules() {

        ApplicationModules.of(AsepApplication.class)
                .verify();

    }

    @Test
    void generateDocumentation() {

        new Documenter(
                ApplicationModules.of(AsepApplication.class))
                .writeDocumentation();

    }

}