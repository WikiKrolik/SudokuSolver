package org.example;

public class SudokuBoard {

    public final int length = 9;
    private SudokuField[][] board = new SudokuField[9][9];
    private ISudokuSolver sudokuSolver;

    public SudokuBoard(ISudokuSolver sudokuSolver) {

        this.sudokuSolver = sudokuSolver;
    }

    public int getNum(int row, int column) {

        return board[row][column].getValue();
    }

    public void setNum(int row, int column, int num) {

        board[row][column].setValue(num);
    }

    public void solveGame(){

        this.sudokuSolver.solve(this);
    }

    public SudokuColumn getColumn(int index){
        SudokuField[] array = new SudokuField[length];
        for (int i = 0; i < 9; i++) {
            array[i] = board[i][index];
        }
       return new SudokuColumn(array);
    }

    public SudokuRow getRow(int index){
        SudokuField[] array = new SudokuField[length];
        for (int i = 0; i < 9; i++) {
            array[i] = board[index][i];
        }
        return new SudokuRow(array);
    }

    public SudokuBox getBox(int row, int column){
        SudokuField[] array = new SudokuField[length];
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++){
                array[i] = board[i][j];
            }
        }
        return new SudokuBox(array);
    }

}
