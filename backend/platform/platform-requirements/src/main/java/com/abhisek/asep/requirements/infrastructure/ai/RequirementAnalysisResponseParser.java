package com.abhisek.asep.requirements.infrastructure.ai;

import com.abhisek.asep.ai.parser.base.AbstractJsonResponseParser;
import com.abhisek.asep.requirements.domain.model.RequirementAnalysis;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class RequirementAnalysisResponseParser
        extends AbstractJsonResponseParser<RequirementAnalysis> {

    public RequirementAnalysisResponseParser(
            ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    protected Class<RequirementAnalysis> targetType() {
        return RequirementAnalysis.class;
    }
}