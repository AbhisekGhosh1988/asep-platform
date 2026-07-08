package com.abhisek.asep.generator.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationModel {

    @Builder.Default
    private List<AggregateModel> aggregates = new ArrayList<>();

}