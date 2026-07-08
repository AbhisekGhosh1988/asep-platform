package com.abhisek.asep.generator.compiler.diagnostic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultDiagnosticReporter implements DiagnosticReporter {

    @Override
    public void report(CompilerDiagnostic diagnostic) {

        switch (diagnostic.getSeverity()) {

            case INFO -> log.info("[{}] {}", diagnostic.getCode(), diagnostic.getMessage());

            case WARNING -> log.warn("[{}] {}", diagnostic.getCode(), diagnostic.getMessage());

            case ERROR -> log.error("[{}] {}", diagnostic.getCode(), diagnostic.getMessage());

        }

    }

}