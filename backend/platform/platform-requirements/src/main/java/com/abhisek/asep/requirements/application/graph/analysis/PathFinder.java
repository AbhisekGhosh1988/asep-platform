package com.abhisek.asep.requirements.application.graph.analysis;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;

import java.util.List;

public interface PathFinder {

    List<GraphNode> shortestPath(Graph graph, GraphNode source, GraphNode target);

}