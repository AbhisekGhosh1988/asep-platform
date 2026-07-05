package com.abhisek.asep.ai.parser.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtils {

    public static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper();

}