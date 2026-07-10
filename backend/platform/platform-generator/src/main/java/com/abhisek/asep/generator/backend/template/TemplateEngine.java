package com.abhisek.asep.generator.backend.template;

public interface TemplateEngine {

    String render(
            Template template,
            TemplateContext context);

}