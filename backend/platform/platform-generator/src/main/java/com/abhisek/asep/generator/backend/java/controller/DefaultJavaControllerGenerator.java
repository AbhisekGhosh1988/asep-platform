package com.abhisek.asep.generator.backend.java.controller;

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
import com.abhisek.asep.generator.ir.model.ApiContractIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaControllerGenerator extends AbstractJavaArtifactGenerator implements JavaControllerGenerator {

    public DefaultJavaControllerGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.CONTROLLER;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof ApiContractIR api)) {
            return;
        }

        Template template = loadTemplate("controller.java.tpl");

        String controllerName = api.getName() + "Controller";

        String useCase = api.getName() + "UseCase";

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".interfaces.rest").put("className", controllerName).put("requestMapping", api.getPath()).put("httpMethod", api.getHttpMethod()).put("requestType", api.getRequestType()).put("responseType", api.getResponseType()).put("useCase", useCase);

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".interfaces.rest", controllerName), source);

        log.info("Generated Controller {}", controllerName);

    }

}