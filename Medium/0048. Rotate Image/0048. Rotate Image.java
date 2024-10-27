class Solution {
    public void rotate(int[][] matrix) {
        int i, j, len = matrix.length;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                matrix[i][j] = matrix[i][j] + matrix[j][i] - (matrix[j][i] = matrix[i][j]);
            }
        }

        for (i = 0; i < len; i++) {
            for (j = 0; j < len / 2; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][len - 1 - j] - (matrix[i][len - 1 - j] = matrix[i][j]);
            }
        }

    }
}