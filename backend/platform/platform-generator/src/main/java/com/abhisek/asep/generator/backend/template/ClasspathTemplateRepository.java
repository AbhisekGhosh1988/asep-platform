package com.abhisek.asep.generator.backend.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class ClasspathTemplateRepository
        implements TemplateRepository {

    @Override
    public Template load(String name) {

        try {

            ClassPathResource resource =
                    new ClassPathResource(
                            "templates/" + name);

            String content =
                    new String(
                            resource.getInputStream()
                                    .readAllBytes(),
                            StandardCharsets.UTF_8);

            return Template.builder()
                    .name(name)
                    .content(content)
                    .build();

        } catch (IOException ex) {

            throw new IllegalStateException(
                    "Unable to load template : " + name,
                    ex);

        }

    }

}