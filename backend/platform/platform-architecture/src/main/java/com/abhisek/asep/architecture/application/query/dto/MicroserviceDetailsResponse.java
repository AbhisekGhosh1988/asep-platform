package com.abhisek.asep.architecture.application.query.dto;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
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
public class MicroserviceDetailsResponse {

    private String id;

    private String name;

    private String description;

    private ArchitectureStyle style;

}