package com.abhisek.asep.generator.session;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationError {

    private String code;

    private String message;

    private Exception exception;

}