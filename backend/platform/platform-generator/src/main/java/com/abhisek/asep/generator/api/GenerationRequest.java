package com.abhisek.asep.generator.api;

import com.abhisek.asep.generator.ir.model.ProjectIR;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GenerationRequest {

    private ProjectIR project;

}