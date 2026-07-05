package com.abhisek.asep.requirements.application.graph.traversal;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;

import java.util.Set;

public interface GraphTraversal {

    Set<GraphNode> traverse(Graph graph, GraphNode startNode);

}