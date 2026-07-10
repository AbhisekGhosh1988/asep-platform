package com.abhisek.asep.generator.model;

import com.abhisek.asep.generator.ir.model.DtoType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DtoModel extends BaseArtifactModel {

    /**
     * Request / Response / Generic DTO.
     */
    private DtoType type;

    /**
     * DTO fields.
     */
    @Builder.Default
    private List<AttributeModel> attributes = new ArrayList<>();

}