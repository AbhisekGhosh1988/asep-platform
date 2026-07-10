package com.abhisek.asep.generator.backend.java.factory;

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
import com.abhisek.asep.generator.ir.model.FactoryIR;
import com.abhisek.asep.generator.ir.model.ServiceOperationIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaFactoryGenerator extends AbstractJavaArtifactGenerator implements JavaFactoryGenerator {

    public DefaultJavaFactoryGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.FACTORY;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof FactoryIR factory)) {

            return;

        }

        Template template = loadTemplate("factory.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".domain.factory").put("className", factory.getName()).put("methods", buildMethods(factory));

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".domain.factory", factory.getName()), source);

        log.info("Generated Factory {}", factory.getName());

    }

    private String buildMethods(FactoryIR factory) {

        StringBuilder builder = new StringBuilder();

        for (ServiceOperationIR method : factory.getMethods()) {

            String returnType = method.getReturnType() == null ? "void" : method.getReturnType();

            builder.append("    public ").append(returnType).append(" ").append(method.getName()).append("(");

            for (int i = 0; i < method.getParameters().size(); i++) {

                var parameter = method.getParameters().get(i);

                builder.append(parameter.getType()).append(" ").append(parameter.getName());

                if (i < method.getParameters().size() - 1) {

                    builder.append(", ");

                }

            }

            builder.append(") {\n");

            builder.append("        throw new UnsupportedOperationException(\"Generated method - implementation pending.\");\n");

            builder.append("    }\n\n");

        }

        return builder.toString();

    }

}