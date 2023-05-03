package org.example;

import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class SudokuBoardTest {

    @Test
    void whenSolveGame_thenSolvedGame() throws NoSuchFieldException, IllegalAccessException {

        ISudokuSolver testSudokuSolver = new BacktrackingSudokuSolver();
        SudokuBoard testBoard = new SudokuBoard(testSudokuSolver);

        testBoard.solveGame();
        for (int i = 0; i < testBoard.length; i++){
            for (int j = 0; j < testBoard.length; j++){
                if (testBoard.getNum(i, j) < 1 || testBoard.getNum(i , j) > 9)
                    Assertions.fail();
                System.out.print(testBoard.getNum(i, j));
            }
            System.out.println();
        }
    }
}
