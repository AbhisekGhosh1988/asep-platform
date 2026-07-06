package com.abhisek.asep.architecture.application.query.dto;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStatus;
import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchitectureDetailsResponse {

    private String id;

    private String projectId;

    private String name;

    private String description;

    private ArchitectureStyle style;

    private ArchitectureStatus status;

    private Integer version;

    @Builder.Default
    private List<BoundedContextDetailsResponse> boundedContexts = new ArrayList<>();

}