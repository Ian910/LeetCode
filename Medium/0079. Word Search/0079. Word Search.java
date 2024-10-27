class Solution {
    public boolean exist(char[][] board, String word) {
        int i, j;
        final int row = board.length, col = board[0].length, len = word.length();
        if (row * col < len) return false;

        boardUse = new int[row][col];
        for (i = 0; i < board.length; i++)
            for (j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0) && (word.length() == 1 || isExist(i, j, 1, board, word)))
                    return true;
        return false;
    }
    int[][] boardUse;

    boolean isExist(int i, int j, int index, char[][] board, String word) {
        boardUse[i][j] = 1;
        boolean isTrue = false;
        if (word.length() > index) {
            if (i > 0 && boardUse[i - 1][j] != 1 && board[i - 1][j] == word.charAt(index))
                if (index == word.length() - 1) return true;
                else {
                    isTrue = isExist(i - 1, j, index + 1, board, word);
                    boardUse[i - 1][j] = 0;
                }
            if (isTrue) return true;
            if (i < board.length - 1 && boardUse[i + 1][j] != 1 && board[i + 1][j] == word.charAt(index))
                if (index == word.length() - 1) return true;
                else {
                    isTrue = isExist(i + 1, j, index + 1, board, word);
                    boardUse[i + 1][j] = 0;
                }
            if (isTrue) return true;
            if (j > 0 && boardUse[i][j - 1] != 1 && board[i][j - 1] == word.charAt(index))
                if (index == word.length() - 1) return true;
                else {
                    isTrue = isExist(i, j - 1, index + 1, board, word);
                    boardUse[i][j - 1] = 0;
                }
            if (isTrue) return true;
            if (j < board[0].length - 1 && boardUse[i][j + 1] != 1 && board[i][j + 1] == word.charAt(index))
                if (index == word.length() - 1) return true;
                else {
                    isTrue = isExist(i, j + 1, index + 1, board, word);
                    boardUse[i][j + 1] = 0;
                }
        }
        boardUse[i][j] = 0;
        return isTrue;
    }
}
