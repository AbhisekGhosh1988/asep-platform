package com.abhisek.asep.generator.backend.java.support;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.spi.ArtifactGenerator;
import com.abhisek.asep.generator.backend.template.Template;
import com.abhisek.asep.generator.backend.template.TemplateContext;
import com.abhisek.asep.generator.backend.template.TemplateEngine;
import com.abhisek.asep.generator.backend.template.TemplateRepository;
import com.abhisek.asep.generator.backend.writer.SourceWriter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Path;

@RequiredArgsConstructor
public abstract class AbstractJavaArtifactGenerator implements ArtifactGenerator {

    protected final TemplateRepository templateRepository;

    protected final TemplateEngine templateEngine;

    protected final SourceWriter sourceWriter;

    /**
     * Loads a template.
     */
    protected Template loadTemplate(String templateName) {

        return templateRepository.load(templateName);

    }

    /**
     * Renders a template.
     */
    protected String render(Template template, TemplateContext context) {

        return templateEngine.render(template, context);

    }

    /**
     * Writes generated source.
     */
    protected void writeSource(Path path, String source) {

        try {

            sourceWriter.write(path, source);

        } catch (IOException ex) {

            throw new RuntimeException("Unable to write generated source : " + path, ex);

        }

    }

    /**
     * Resolve Java output file.
     */
    protected Path resolveJavaFile(GenerationContext context, String packageName, String className) {

        return context.resolveJavaFile(packageName, className);

    }


}