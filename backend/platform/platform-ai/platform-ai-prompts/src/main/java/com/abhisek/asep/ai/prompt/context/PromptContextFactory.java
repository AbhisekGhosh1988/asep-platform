package com.abhisek.asep.ai.prompt.context;

public interface PromptContextFactory<T> {

    PromptContext create(T input);

}