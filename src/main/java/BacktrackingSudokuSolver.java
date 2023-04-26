
public class BacktrackingSudokuSolver implements SudokuSolver{

    @Override
    public void solve(SudokuBoard sudokuBoard) {
        for (int i = 0; i < sudokuBoard.length; i++){
            for (int j = 0; j < sudokuBoard.length; j++){
                sudokuBoard.setNum(i, j, 0);
            }
        }
        recursiveFillBoard(sudokuBoard);
    }

    private boolean recursiveFillBoard(SudokuBoard sudokuBoard){
        int row = -1;
        int column = -1;
        boolean isEmpty = false;
        for (int i = 0; i < sudokuBoard.length; i++){
            for (int j = 0; j < sudokuBoard.length; j++){
                if (sudokuBoard.getNum(i, j) == 0){
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
            if (isSafe(sudokuBoard, row, column, i)){
                sudokuBoard.setNum(row, column, i);
                if (recursiveFillBoard(sudokuBoard))
                    return true;
                else
                    sudokuBoard.setNum(row, column, 0);
            }
        }
        return false;
    }

    private boolean isSafe(SudokuBoard sudokuBoard, int row, int column, int num){
        for (int i = 0; i < sudokuBoard.length; i++){
            if (sudokuBoard.getNum(row, i) == num)
                return false;
        }
        for (int j = 0; j < sudokuBoard.length; j++){
            if (sudokuBoard.getNum(j, column) == num)
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
                if (sudokuBoard.getNum(r, c) == num)
                {
                    return false;
                }
            }
        }
        return true;

    }
}
