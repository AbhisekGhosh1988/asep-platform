package com.abhisek.asep.generator.backend.java.policy;

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
import com.abhisek.asep.generator.ir.model.PolicyIR;
import com.abhisek.asep.generator.ir.model.ServiceOperationIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultJavaPolicyGenerator extends AbstractJavaArtifactGenerator implements JavaPolicyGenerator {

    public DefaultJavaPolicyGenerator(TemplateRepository templateRepository, TemplateEngine templateEngine, SourceWriter sourceWriter) {

        super(templateRepository, templateEngine, sourceWriter);

    }

    @Override
    public ArtifactType getArtifactType() {

        return ArtifactType.POLICY;

    }

    @Override
    public void generate(GenerationTask step, CompilerResult compilerResult, GenerationContext generationContext) {

        if (!(step.getNode() instanceof PolicyIR policy)) {

            return;

        }

        Template template = loadTemplate("policy.java.tpl");

        TemplateContext context = new TemplateContext().put("package", generationContext.getBasePackage() + ".domain.policy").put("className", policy.getName()).put("methods", buildMethods(policy));

        String source = render(template, context);

        writeSource(resolveJavaFile(generationContext, generationContext.getBasePackage() + ".domain.policy", policy.getName()), source);

        log.info("Generated Policy {}", policy.getName());

    }

    private String buildMethods(PolicyIR policy) {

        StringBuilder builder = new StringBuilder();

        for (ServiceOperationIR operation : policy.getOperations()) {

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

            builder.append("        throw new UnsupportedOperationException(\"Generated policy - implementation pending.\");\n");

            builder.append("    }\n\n");

        }

        return builder.toString();

    }

}