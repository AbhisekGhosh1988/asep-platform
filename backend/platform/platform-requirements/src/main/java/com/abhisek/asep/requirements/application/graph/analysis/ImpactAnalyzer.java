package com.abhisek.asep.requirements.application.graph.analysis;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;

import java.util.Set;

public interface ImpactAnalyzer {

    Set<GraphNode> impactedNodes(
            Graph graph,
            GraphNode changedNode);

}