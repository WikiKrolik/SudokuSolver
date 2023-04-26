
public class SudokuBoard {

    public final int length = 9;
    private int[][] board = new int[length][length];



    public SudokuBoard(int[][] board) {
        this.board = board;
    }


    public int getNum(int row, int column) {
        return board[row][column];
    }

    public void setNum(int row, int column, int num) {
        board[row][column] = num;
    }

    public void solveGame(){
        SudokuBoard newBoard = new SudokuBoard(board);
        SudokuSolver sudokuSolver = new BacktrackingSudokuSolver();
        sudokuSolver.solve(newBoard);
    }




}
