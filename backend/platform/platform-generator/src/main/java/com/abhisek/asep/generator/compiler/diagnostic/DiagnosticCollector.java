package com.abhisek.asep.generator.compiler.diagnostic;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DiagnosticCollector {

    private final List<CompilerDiagnostic> diagnostics = new ArrayList<>();

    public void add(CompilerDiagnostic diagnostic) {

        diagnostics.add(diagnostic);

    }

    public void info(String code, String message, String source) {

        diagnostics.add(CompilerDiagnostic.builder().code(code).severity(DiagnosticSeverity.INFO).message(message).source(source).build());

    }

    public void warning(String code, String message, String source) {

        diagnostics.add(CompilerDiagnostic.builder().code(code).severity(DiagnosticSeverity.WARNING).message(message).source(source).build());

    }

    public void error(String code, String message, String source) {

        diagnostics.add(CompilerDiagnostic.builder().code(code).severity(DiagnosticSeverity.ERROR).message(message).source(source).build());

    }

    public List<CompilerDiagnostic> getDiagnostics() {

        return Collections.unmodifiableList(diagnostics);

    }

    public boolean hasErrors() {

        return diagnostics.stream().anyMatch(d -> d.getSeverity() == DiagnosticSeverity.ERROR);

    }

    public void clear() {

        diagnostics.clear();

    }

}