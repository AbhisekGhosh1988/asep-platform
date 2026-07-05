package com.abhisek.asep.requirements.application.graph.analysis;

import com.abhisek.asep.requirements.application.graph.model.Graph;

public interface CycleDetector {

    boolean hasCycle(Graph graph);

}