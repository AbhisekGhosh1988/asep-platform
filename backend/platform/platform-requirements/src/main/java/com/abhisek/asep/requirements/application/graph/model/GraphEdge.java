package com.abhisek.asep.requirements.application.graph.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GraphEdge {

    private GraphNode source;

    private GraphNode target;

    private String relation;

}