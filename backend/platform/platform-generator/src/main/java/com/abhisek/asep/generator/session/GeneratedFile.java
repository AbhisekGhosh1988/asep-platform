package com.abhisek.asep.generator.session;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratedFile {

    private String fileName;

    private String relativePath;

    private String absolutePath;

    private String content;

}