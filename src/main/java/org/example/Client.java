package org.example;

public class Client {

    public static void main(String[] args){

        SudokuBoard sudokuBoard = new SudokuBoard(new BacktrackingSudokuSolver());
        sudokuBoard.solveGame();

        SudokuBoardDaoFactory file = new SudokuBoardDaoFactory();
        file.getFileDao().write(sudokuBoard);


        System.out.println(file.getFileDao().read());

    }
}
