import java.util.Random;

public class SudokuBoard {

    private int[][] board = new int[9][9];


    public void fillBoard(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = 0;
            }
        }
        recursiveFillBoard();
    }

    private boolean recursiveFillBoard(){
        int row = -1;
        int column = -1;
        boolean isEmpty = false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == 0){
                    row = i;
                    column = j;
                    isEmpty = true;
                    break;
                }
            }
            if (isEmpty)
                break;
        }
        if (!isEmpty)
            return true;

        for (int i = 1; i < 10; i++){
            if (isSafe(board, row, column, i)){
                board[row][column] = i;
                if (recursiveFillBoard())
                    return true;
                else
                    board[row][column] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int column, int num){
        for (int i = 0; i < board.length; i++){
            if (board[row][i] == num)
                return false;
        }
        for (int j = 0; j < board.length; j++){
            if (board[j][column] == num)
                return false;
        }

        int[][] square = new int[3][3];
        int startIndexRow = row - row%3;
        int startIndexColumn = column - column%3;

        for (int r = startIndexRow;
             r < startIndexRow + 3; r++)
        {
            for (int c = startIndexColumn ;
                 c < startIndexColumn + 3; c++)
            {
                if (board[r][c] == num)
                {
                    return false;
                }
            }
        }
        return true;

    }
}
