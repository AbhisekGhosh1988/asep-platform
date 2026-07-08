package com.abhisek.asep.generator.session;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationWarning {

    private String code;

    private String message;

}