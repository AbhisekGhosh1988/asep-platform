package com.abhisek.asep.requirements.application.ai.context;

import com.abhisek.asep.ai.prompt.builder.requirement.RequirementPromptVariables;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.requirements.domain.model.Requirement;
import org.springframework.stereotype.Component;

@Component
public class RequirementPromptContextFactory implements PromptContextFactory<Requirement> {

    @Override
    public PromptContext create(Requirement requirement) {

        PromptContext context = PromptContext.builder().build();

        context.put(RequirementPromptVariables.TITLE, requirement.getTitle());

        context.put(RequirementPromptVariables.DESCRIPTION, requirement.getDescription());

        context.put(RequirementPromptVariables.TYPE, requirement.getType());

        context.put(RequirementPromptVariables.PRIORITY, requirement.getPriority());

        context.put(RequirementPromptVariables.COMPLEXITY, requirement.getComplexity());

        return context;

    }

}