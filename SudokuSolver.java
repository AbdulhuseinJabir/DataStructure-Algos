public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
          };

          solve(board);
          printBoard(board);
    }

    static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board))
                                return true;
                            else
                                board[row][col] = 0;
                        }
                    }
                    return false; // No solution found for that empty box. Go back to previous box and see other values which can complete the sudoku. 
                }
            }    
        }
        return true; // Sudoku is solved.
    }

    static boolean isValid (int[][] board, int row, int col, int num) {
        return (!isInRow(board, row, num) && !isInCol(board, col, num) && !isInBox(board, row, col, num));
    }

    static boolean isInRow(int[][] board, int row, int num) {
        for (int a = 0; a < 9; a++) {
            if(board[row][a] == num)
                return true;
        }
        return false;
    }

    static boolean isInCol(int[][] board, int col, int num) {
        for (int a = 0; a < 9; a++) {
            if(board[a][col] == num)
                return true;
        }
        return false;
    }

    static boolean isInBox(int[][] board, int row, int col, int num) {
        row = row - row % 3; // This is to get the start index for that row box. 
        col = col - col % 3; // This is to get the start index for that col box.

        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                if (board[i][j] == num)
                    return true;
            }   
        }
        return false;
    }

    static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }    
    }
}
