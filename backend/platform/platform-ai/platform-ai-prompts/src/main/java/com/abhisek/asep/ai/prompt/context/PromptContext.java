package com.abhisek.asep.ai.prompt.context;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class PromptContext {

    @Builder.Default
    private final Map<String, Object> variables =
            new HashMap<>();

    public PromptContext put(
            String key,
            Object value) {

        variables.put(key, value);

        return this;

    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {

        return (T) variables.get(key);

    }

}