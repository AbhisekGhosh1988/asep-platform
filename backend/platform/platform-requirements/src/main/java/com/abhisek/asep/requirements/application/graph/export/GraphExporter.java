package com.abhisek.asep.requirements.application.graph.export;

import com.abhisek.asep.requirements.application.graph.model.Graph;

public interface GraphExporter {

    String export(Graph graph);

}