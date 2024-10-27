public class Solution {
    public boolean isValidSudoku(char[][] board) {
        char num;
        int i, j;
        for (i = 0; i < 81; i++) {
            num = board[i / 9][i % 9];
            if (num != '.') {
                for (j = 0; j < 9; j++) {
                    if (board[i / 9][j] == num && j != i % 9) {
                        return false;
                    }
                    if (board[j][i % 9] == num && j != i / 9) {
                        return false;
                    }
                    if (board[i / 9 / 3 * 3 + j / 3][i % 9 / 3 * 3 + j % 3] == num
                            && ((i / 9 / 3 * 3) + (j / 3) != (i / 9)) && ((i % 9 / 3 * 3) + (j % 3) != (i % 9))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
