package org.example;

import java.io.*;
import java.util.Scanner;

public class FileSudokuBoardDao implements IDao<SudokuBoard>{

    private String fileName;

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard board = null;

        try(ObjectInputStream sudoku = new ObjectInputStream(new FileInputStream(fileName))){

            board = (SudokuBoard) sudoku.readObject();


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return board;
    }

    @Override
    public void write(SudokuBoard object) {

        try(ObjectOutputStream sudoku = new ObjectOutputStream(new FileOutputStream(fileName))){

            sudoku.writeObject(object);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
