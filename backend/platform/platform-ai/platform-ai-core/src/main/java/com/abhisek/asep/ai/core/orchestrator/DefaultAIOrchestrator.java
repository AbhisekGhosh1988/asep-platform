package com.abhisek.asep.ai.core.orchestrator;

import com.abhisek.asep.ai.core.model.request.AIRequest;
import com.abhisek.asep.ai.core.model.response.AIResponse;
import com.abhisek.asep.ai.core.parser.ResponseParser;
import com.abhisek.asep.ai.core.prompt.PromptBuilder;
import com.abhisek.asep.ai.core.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAIOrchestrator implements AIOrchestrator {

    private final AIService aiService;

    @Override
    public <I, O> O execute(PromptBuilder<I> promptBuilder, I input, ResponseParser<O> parser) {

        AIRequest request = promptBuilder.build(input);

        AIResponse response = aiService.generate(request);

        return parser.parse(response);

    }

}