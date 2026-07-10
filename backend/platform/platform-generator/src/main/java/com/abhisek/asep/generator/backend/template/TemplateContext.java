package com.abhisek.asep.generator.backend.template;

import java.util.HashMap;
import java.util.Map;

public class TemplateContext {

    private final Map<String, Object> variables =
            new HashMap<>();

    public TemplateContext put(
            String key,
            Object value) {

        variables.put(key, value);

        return this;

    }

    public Object get(String key) {

        return variables.get(key);

    }

    public Map<String, Object> variables() {

        return variables;

    }

}