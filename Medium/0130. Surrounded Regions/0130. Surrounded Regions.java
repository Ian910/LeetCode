class Solution {
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length, i, j;
        for (i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'F';
                process(board, 1, i);
            }
            if (board[row - 1][i] == 'O') {
                board[row - 1][i] = 'F';
                process(board, row - 2, i);
            }
        }
        for (i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'F';
                process(board, i, 1);
            }
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = 'F';
                process(board, i, col - 2);
            }
        }
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (board[i][j] == 'X')
                    ;
                else if (board[i][j] == 'F')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    public void process(char[][] board, int i, int j) {
        int row = board.length, col = board[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] != 'O') return;
        board[i][j] = 'F';

        if (i != 0 && board[i - 1][j] == 'O') process(board, i - 1, j);
        if (i != row - 1 && board[i + 1][j] == 'O') process(board, i + 1, j);
        if (j != 0 && board[i][j - 1] == 'O') process(board, i, j - 1);
        if (j != col- 1 && board[i][j + 1] == 'O') process(board, i, j + 1);
    }
}