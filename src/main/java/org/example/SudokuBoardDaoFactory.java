package org.example;

public class SudokuBoardDaoFactory {


    public IDao<SudokuBoard> getFileDao(){
        return new FileSudokuBoardDao("sudoku.txt");
    }
}
