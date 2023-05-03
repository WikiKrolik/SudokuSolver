package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class SudokuGroup {

    public static final int SIZE = 9;
    private final List<SudokuField> sudokuFields;

    protected SudokuGroup(List<SudokuField> sudokuFields) {
        this.sudokuFields = sudokuFields;
    }

    public boolean verify() {
        for (SudokuField x: sudokuFields) {
            for (SudokuField y: sudokuFields) {
                if (x.getValue() == y.getValue() && x != y || (x.getValue() == 0
                        || y.getValue() == 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuGroup)) return false;
        SudokuGroup that = (SudokuGroup) o;
        return Objects.equals(sudokuFields, that.sudokuFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sudokuFields);
    }

    @Override
    public String toString() {
        return "SudokuGroup{" +
                "sudokuFields=" + sudokuFields +
                '}';
    }
}
