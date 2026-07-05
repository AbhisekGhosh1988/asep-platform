package com.abhisek.asep.requirements.application.graph.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Graph {

    private final List<GraphNode> nodes = new ArrayList<>();

    private final List<GraphEdge> edges = new ArrayList<>();

    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    public void addEdge(GraphEdge edge) {
        edges.add(edge);
    }

}