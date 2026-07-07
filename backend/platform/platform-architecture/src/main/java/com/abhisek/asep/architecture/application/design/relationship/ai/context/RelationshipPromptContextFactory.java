package com.abhisek.asep.architecture.application.design.relationship.ai.context;

import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.context.PromptContextFactory;
import com.abhisek.asep.architecture.application.design.relationship.ai.prompt.RelationshipPromptVariables;
import org.springframework.stereotype.Component;

@Component
public class RelationshipPromptContextFactory implements PromptContextFactory<String> {

    @Override
    public PromptContext create(String aggregate) {

        return PromptContext.builder().build().put(RelationshipPromptVariables.AGGREGATE, aggregate);

    }

}