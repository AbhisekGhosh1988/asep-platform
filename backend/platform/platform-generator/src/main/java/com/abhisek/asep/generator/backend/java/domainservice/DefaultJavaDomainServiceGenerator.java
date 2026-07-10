package com.abhisek.asep.generator.backend.java.domainservice;

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
import com.abhisek.asep.generator.ir.model.ServiceOperationIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaDomainServiceGenerator extends AbstractJavaArtifactGenerator implements JavaDomainServiceGenerator {

    public DefaultJavaDomainServiceGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.DOMAIN_SERVICE;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof DomainServiceIR service)) {

            return;

        }

        Template template = loadTemplate("domain-service.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".domain.service").put("className", service.getName()).put("methods", buildMethods(service));

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".domain.service", service.getName()), source);

        log.info("Generated Domain Service {}", service.getName());

    }

    private String buildMethods(DomainServiceIR service) {

        StringBuilder builder = new StringBuilder();

        for (ServiceOperationIR operation : service.getOperations()) {

            String returnType = operation.getReturnType() == null ? "void" : operation.getReturnType();

            builder.append("    public ").append(returnType).append(" ").append(operation.getName()).append("(");

            for (int i = 0; i < operation.getParameters().size(); i++) {

                var parameter = operation.getParameters().get(i);

                builder.append(parameter.getType()).append(" ").append(parameter.getName());

                if (i < operation.getParameters().size() - 1) {

                    builder.append(", ");

                }

            }

            builder.append(") {\n");

            if ("void".equals(returnType)) {

                builder.append("        throw new UnsupportedOperationException(\"Generated method - implementation pending.\");\n");

            } else {

                builder.append("        throw new UnsupportedOperationException(\"Generated method - implementation pending.\");\n");

            }

            builder.append("    }\n\n");

        }

        return builder.toString();

    }
}
