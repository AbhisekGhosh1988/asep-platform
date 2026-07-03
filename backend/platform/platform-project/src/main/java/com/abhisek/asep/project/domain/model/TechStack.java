package com.abhisek.asep.project.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TechStack {

    private String backend;

    private String frontend;

    private String database;

    private String messaging;

    private String buildTool;

    private String cloud;

    private String container;

}