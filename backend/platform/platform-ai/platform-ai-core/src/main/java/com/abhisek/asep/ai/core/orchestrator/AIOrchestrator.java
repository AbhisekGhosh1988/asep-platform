package com.abhisek.asep.ai.core.orchestrator;

import com.abhisek.asep.ai.core.parser.ResponseParser;
import com.abhisek.asep.ai.core.prompt.PromptBuilder;

public interface AIOrchestrator {

    <I, O> O execute(PromptBuilder<I> promptBuilder, I input, ResponseParser<O> parser);

}