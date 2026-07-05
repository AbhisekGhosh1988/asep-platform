package com.abhisek.asep.core.support.diff;

import java.util.ArrayList;
import java.util.List;

public class DiffResult {

    private final List<FieldDifference> differences = new ArrayList<>();

    public List<FieldDifference> getDifferences() {
        return differences;
    }

    public boolean hasChanges() {
        return !differences.isEmpty();
    }

    public void addDifference(FieldDifference difference) {
        differences.add(difference);
    }
}