package com.abhisek.asep.generator.backend.java.applicationservice;

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
import com.abhisek.asep.generator.ir.model.DomainServiceIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaApplicationServiceGenerator extends AbstractJavaArtifactGenerator implements JavaApplicationServiceGenerator {

    public DefaultJavaApplicationServiceGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.APPLICATION_SERVICE;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof DomainServiceIR service)) {
            return;
        }

        Template template = loadTemplate("templates/application-service.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".application.service").put("className", service.getName() + "ApplicationService").put("domainService", service.getName());

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".application.service", service.getName() + "ApplicationService"), source);

        log.info("Generated Application Service {}", service.getName());

    }

}