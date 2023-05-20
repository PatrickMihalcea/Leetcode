// Medium. Arrays and Hashing.
// May 20 2023
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Iterate through board.
        for (int i = 0; i < 9; i++) { // Row.
            for (int j = 0; j < 9; j++) { // Column.

                char val = board[i][j];
                if (val == '.') continue;

                // Check remaining chars in column.
                for (int k = i + 1; k < 9; k++) {
                    if (board[k][j] == val) return false;
                }

                // Check remaining chars in row.
                for (int k = j + 1; k < 9; k++) {
                    if (board[i][k] == val) return false;
                }

                
                // Check block.
                int horBlock = i/3;
                int verBlock = j/3;
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        if ((horBlock*3 + a == i) && (verBlock*3 + b == j)) {
                            continue; // Same as curent square, skip.
                        }
                        if (board[horBlock*3 + a][verBlock*3 + b] == val) return false;
                    }
                }
            }
        }

        return true;
    }
}
