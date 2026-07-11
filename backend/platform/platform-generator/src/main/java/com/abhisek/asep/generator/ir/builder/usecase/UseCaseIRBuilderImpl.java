package com.abhisek.asep.generator.ir.builder.usecase;

import com.abhisek.asep.generator.ir.model.UseCaseIR;
import com.abhisek.asep.generator.ir.model.UseCaseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UseCaseIRBuilderImpl implements UseCaseIRBuilder {

    @Override
    public UseCaseIR build(UseCaseModel source) {

        if (source == null) {
            throw new IllegalArgumentException("UseCaseModel cannot be null.");
        }

        if (source.getType() == null) {
            throw new IllegalArgumentException("UseCase type cannot be null.");
        }

        return UseCaseIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .type(
                        com.abhisek.asep.generator.ir.model.UseCaseType.valueOf(
                                source.getType().name()))
                .requestDto(source.getRequestDto())
                .responseDto(source.getResponseDto())
                .build();

    }

}