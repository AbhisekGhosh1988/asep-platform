package com.abhisek.asep.ai.prompt.util;

public final class PromptUtils {

    private PromptUtils() {
    }

    public static String replace(

            String template,

            String variable,

            Object value) {

        return template.replace(

                "{{" + variable + "}}",

                value == null ? "" : value.toString());

    }

}