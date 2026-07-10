package com.abhisek.asep.generator.backend.java.query;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.java.support.AbstractJavaArtifactGenerator;
import com.abhisek.asep.generator.backend.spi.ArtifactType;
import com.abhisek.asep.generator.backend.template.Template;
import com.abhisek.asep.generator.backend.template.TemplateContext;
import com.abhisek.asep.generator.backend.template.TemplateEngine;
import com.abhisek.asep.generator.backend.template.TemplateRepository;
import com.abhisek.asep.generator.backend.writer.SourceWriter;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.compiler.planner.GenerationTask;
import com.abhisek.asep.generator.ir.model.QueryIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaQueryGenerator extends AbstractJavaArtifactGenerator implements JavaQueryGenerator {

    public DefaultJavaQueryGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.QUERY;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof QueryIR query)) {

            return;

        }

        String packageName = generationContext.getBasePackage() + ".application.query";

        Template template = loadTemplate("query.java.tpl");

        TemplateContext context = new TemplateContext().put("package", packageName).put("className", query.getName()).put("handler", query.getHandler()).put("responseType", query.getResponseType());

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, packageName, query.getName()), source);

        log.info("Generated Query {}", query.getName());

    }

}