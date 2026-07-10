package com.abhisek.asep.generator.compiler.semantic;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Result of semantic validation.
 */
@Getter
public class SemanticValidationResult {

    private final List<SemanticError> errors =
            new ArrayList<>();

    public void addError(SemanticError error) {

        errors.add(error);

    }

    public boolean isSuccess() {

        return errors.isEmpty();

    }

    public List<SemanticError> getErrors() {

        return Collections.unmodifiableList(errors);

    }

}