package com.abhisek.asep.requirements.application.graph.engine;

import com.abhisek.asep.requirements.application.graph.model.Graph;
import com.abhisek.asep.requirements.application.graph.model.GraphEdge;
import com.abhisek.asep.requirements.application.graph.model.GraphNode;
import org.springframework.stereotype.Component;

@Component
public class GraphEngine {

    public void addNode(Graph graph, GraphNode node) {

        if (graph.getNodes().stream().noneMatch(n -> n.getId().equals(node.getId()) && n.getType().equals(node.getType()))) {

            graph.getNodes().add(node);

        }

    }

    public void addEdge(Graph graph, GraphEdge edge) {

        graph.getEdges().add(edge);

    }

}