package com.abhisek.asep.ai.core.workflow.support;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.parser.ResponseParser;
import com.abhisek.asep.ai.core.prompt.PromptBuilder;
import com.abhisek.asep.ai.core.service.AIService;
import com.abhisek.asep.ai.core.workflow.AIWorkflow;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractAIWorkflow<I, C, O> implements AIWorkflow<I, O> {

    private final AIService aiService;

    protected abstract C createContext(I input);

    protected abstract PromptBuilder<C> promptBuilder();

    protected abstract ResponseParser<O> responseParser();

    @Override
    public O execute(I input) {

        C context = createContext(input);

        AIRequest request = promptBuilder().build(context);

        AIResponse response = aiService.generate(request);

        return responseParser().parse(response);

    }

}