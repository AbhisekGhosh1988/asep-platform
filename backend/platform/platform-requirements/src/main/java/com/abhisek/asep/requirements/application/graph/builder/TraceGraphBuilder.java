package com.abhisek.asep.requirements.application.graph.builder;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.domain.enums.TraceEntityType;

public interface TraceGraphBuilder {

    Graph buildGraph(TraceEntityType entityType, String entityId);

}