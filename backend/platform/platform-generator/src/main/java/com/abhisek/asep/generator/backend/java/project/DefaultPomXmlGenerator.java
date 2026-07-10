package com.abhisek.asep.generator.backend.java.project;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.writer.SourceWriter;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultPomXmlGenerator
        implements PomXmlGenerator {

    private final SourceWriter sourceWriter;

    @Override
    public void generate(
            CompilerResult compilerResult,
            GenerationContext context) {

        String pom = """
                <?xml version="1.0" encoding="UTF-8"?>
                <project xmlns="http://maven.apache.org/POM/4.0.0"
                         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                         https://maven.apache.org/xsd/maven-4.0.0.xsd">

                    <modelVersion>4.0.0</modelVersion>

                    <parent>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-parent</artifactId>
                        <version>3.5.4</version>
                    </parent>

                    <groupId>com.abhisek.generated</groupId>

                    <artifactId>generated-service</artifactId>

                    <version>1.0.0-SNAPSHOT</version>

                    <properties>

                        <java.version>21</java.version>

                    </properties>

                    <dependencies>

                        <dependency>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-starter-web</artifactId>
                        </dependency>

                        <dependency>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-starter-data-jpa</artifactId>
                        </dependency>

                        <dependency>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <optional>true</optional>
                        </dependency>

                        <dependency>
                            <groupId>com.h2database</groupId>
                            <artifactId>h2</artifactId>
                            <scope>runtime</scope>
                        </dependency>

                    </dependencies>

                    <build>

                        <plugins>

                            <plugin>

                                <groupId>org.springframework.boot</groupId>

                                <artifactId>spring-boot-maven-plugin</artifactId>

                            </plugin>

                        </plugins>

                    </build>

                </project>
                """;

        try {

            sourceWriter.write(
                    context.getProjectRoot()
                            .resolve("pom.xml"),
                    pom);

        } catch (IOException ex) {

            throw new RuntimeException(
                    "Unable to generate pom.xml",
                    ex);

        }

        log.info(
                "Generated pom.xml");

    }

}