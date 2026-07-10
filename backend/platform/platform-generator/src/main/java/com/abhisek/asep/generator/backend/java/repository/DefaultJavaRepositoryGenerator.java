package com.abhisek.asep.generator.backend.java.repository;

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
import com.abhisek.asep.generator.ir.model.RepositoryIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaRepositoryGenerator extends AbstractJavaArtifactGenerator implements JavaRepositoryGenerator {

    public DefaultJavaRepositoryGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.REPOSITORY;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof RepositoryIR repository)) {

            return;

        }

        Template template = loadTemplate("repository.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".repository").put("entityPackage", generationContext.getBasePackage() + ".entity").put("entityClass", repository.getEntityName()).put("repositoryName", repository.getName()).put("idType", repository.getIdType());

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".repository", repository.getName()), source);

        log.info("Generated Repository {}", repository.getName());

    }

}