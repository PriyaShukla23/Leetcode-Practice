class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // This function tries to solve the Sudoku
    private boolean solve(char[][] board) {

        // Step 1: Find an empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // If the cell is empty
                if (board[row][col] == '.') {

                    // Try numbers 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        // Check whether this number can be placed here
                        if (isValid(board, row, col, num)) {

                            // Place the number
                            board[row][col] = num;

                            // Recursively solve the remaining Sudoku
                            if (solve(board)) {
                                return true;
                            }

                            // If solution didn't work,
                            // undo the choice (BACKTRACK)
                            board[row][col] = '.';
                        }
                    }

                    // No number from 1-9 worked here
                    return false;
                }
            }
        }

        // No empty cells left
        // Sudoku is completely solved
        return true;
    }

    // Checks whether 'num' can be placed at board[row][col]
    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            // Check the row
            if (board[row][i] == num) {
                return false;
            }

            // Check the column
            if (board[i][col] == num) {
                return false;
            }

            // Find the starting position of the 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            // Check the 3x3 box
            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }

        // Number is safe
        return true;
    }
}