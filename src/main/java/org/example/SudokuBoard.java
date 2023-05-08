package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuBoard implements Serializable {

    public final int length = 9;
    private SudokuField[][] board = new SudokuField[9][9];
    private ISudokuSolver sudokuSolver;

    public SudokuBoard(ISudokuSolver sudokuSolver) {

        this.sudokuSolver = sudokuSolver;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                board[i][j] = new SudokuField();
            }
        }
    }

    public int getNum(int row, int column) {

        return board[row][column].getValue();
    }

    public void setNum(int row, int column, int num) {

        board[row][column].setValue(num);
    }

    public void solveGame() {

        this.sudokuSolver.solve(this);
    }

    public SudokuColumn getColumn(int index) {
        SudokuField[] array = new SudokuField[length];
        for (int i = 0; i < 9; i++) {
            array[i] = board[i][index];
        }
        return new SudokuColumn(Arrays.asList(array));
    }

    public SudokuRow getRow(int index) {
        SudokuField[] array = new SudokuField[length];
        for (int i = 0; i < 9; i++) {
            array[i] = board[index][i];
        }
        return new SudokuRow(Arrays.asList(array));
    }

    public SudokuBox getBox(int row, int column) {
        SudokuField[] array = new SudokuField[length];
        int r = row / 3;
        int c = column / 3;
        for (int i = r * 3; i < r * 3 + 3; i++) {
            for (int j = c * 3; j < c * 3 + 3; j++) {
                array[i] = board[i][j];
            }
        }
        return new SudokuBox(Arrays.asList(array));
    }

    @Override
    public String toString() {
        String result =  "SudokuBoard{" +
                "board=" + "\n";
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                result += board[i][j].getValue();
            }
            result+= "\n";
        }
        result+= "}";
       return result;
    }
}
