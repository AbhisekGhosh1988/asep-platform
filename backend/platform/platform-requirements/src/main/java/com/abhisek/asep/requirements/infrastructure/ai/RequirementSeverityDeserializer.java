package com.abhisek.asep.requirements.infrastructure.ai;

import com.abhisek.asep.ai.parser.enums.EnumNormalizer;
import com.abhisek.asep.requirements.domain.enums.RequirementIssueSeverity;
import com.abhisek.asep.requirements.domain.enums.RequirementIssueType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class RequirementSeverityDeserializer extends JsonDeserializer<RequirementIssueSeverity> {

    @Override
    public RequirementIssueSeverity deserialize(
            JsonParser parser,
            DeserializationContext context)
            throws IOException {

        String value = parser.getValueAsString();

        return RequirementIssueSeverity.valueOf(
                EnumNormalizer.normalize(value));

    }

}