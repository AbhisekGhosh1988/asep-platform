package com.abhisek.asep.ai.parser.enums;

public final class EnumNormalizer {

    private EnumNormalizer() {
    }

    public static String normalize(String value) {

        if (value == null) {
            return null;
        }

        return value
                .trim()
                .replace('-', '_')
                .replace(' ', '_')
                .toUpperCase();

    }

}