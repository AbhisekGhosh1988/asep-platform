package com.abhisek.asep.requirements.application.graph.export;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JsonGraphExporter implements GraphExporter {

    private final ObjectMapper objectMapper;

    @Override
    public String export(Graph graph) {

        try {

            return objectMapper.writeValueAsString(graph);

        } catch (JsonProcessingException ex) {

            throw new IllegalStateException("Unable to export graph", ex);

        }

    }

}