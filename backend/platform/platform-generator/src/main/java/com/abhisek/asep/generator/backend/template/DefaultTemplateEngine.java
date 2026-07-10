package com.abhisek.asep.generator.backend.template;

import org.springframework.stereotype.Component;

@Component
public class DefaultTemplateEngine
        implements TemplateEngine {

    @Override
    public String render(
            Template template,
            TemplateContext context) {

        String content =
                template.getContent();

        for (var entry : context.variables().entrySet()) {

            content = content.replace(
                    "${" + entry.getKey() + "}",
                    String.valueOf(entry.getValue()));

        }

        return content;

    }

}