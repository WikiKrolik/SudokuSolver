import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class SudokuBoardTest {

    @Test
    void givenSudokuBoard_whenFillBoard_thenReturnTrue() throws NoSuchFieldException, IllegalAccessException {

        SudokuBoard testBoard = new SudokuBoard();
        Field field = SudokuBoard.class.getDeclaredField("board");
        field.setAccessible(true);
        int[][] board = (int[][]) field.get(testBoard);
        testBoard.fillBoard();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] < 1 || board[i][j] > 9)
                    Assertions.fail();
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
