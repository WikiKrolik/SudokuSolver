import org.example.BacktrackingSudokuSolver;
import org.example.ISudokuSolver;
import org.example.SudokuBoard;
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
        Field field = SudokuBoard.class.getDeclaredField("board");
        field.setAccessible(true);
        int[][] board = (int[][]) field.get(testBoard);
        testBoard.solveGame();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] < 1 || board[i][j] > 9)
                    Assertions.fail();
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    void checkRows(){
        ISudokuSolver testSudokuSolver = new BacktrackingSudokuSolver();
        SudokuBoard testBoard = new SudokuBoard(testSudokuSolver);
        testBoard.solveGame();

        for( int i = 0; i < testBoard.length; i++){
            boolean[] array = new boolean[9];
            for (int j = 0; j < testBoard.length; j++){
                array[testBoard.getNum(i,j) - 1] = true;
            }
            for (boolean isPresent: array
                 ) {
                if(!isPresent)
                    Assertions.fail();
            }
        }
    }

    @Test
    void checkColumns(){
        ISudokuSolver testSudokuSolver = new BacktrackingSudokuSolver();
        SudokuBoard testBoard = new SudokuBoard(testSudokuSolver);
        testBoard.solveGame();

        for( int i = 0; i < testBoard.length; i++){
            boolean[] array = new boolean[9];
            for (int j = 0; j < testBoard.length; j++){
                array[testBoard.getNum(j, i) - 1] = true;
            }
            for (boolean isPresent: array
            ) {
                if(!isPresent)
                    Assertions.fail();
            }
        }
    }
}
