package com.abhisek.asep.ai.prompt.context;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromptContext {

    @Builder.Default
    private Map<String, Object> variables = new HashMap<>();

    public PromptContext add(String key, Object value) {

        variables.put(key, value);

        return this;

    }

    public Object get(String key) {

        return variables.get(key);

    }

}