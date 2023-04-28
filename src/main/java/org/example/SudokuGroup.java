package org.example;

import java.util.List;

public abstract class SudokuGroup {

    public static final int SIZE = 9;
    private final SudokuField[] sudokuFields;

    protected SudokuGroup(SudokuField[] sudokuFields) {
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
}
