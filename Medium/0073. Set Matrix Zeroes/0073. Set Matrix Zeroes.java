class Solution {
    public void setZeroes(int[][] matrix) {
        int i, j;
        int[] rowZero = new int[matrix[0].length], colZero = new int[matrix.length];
        for (i = 0; i < matrix.length; i++)
            for (j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) {
                    rowZero[j] = 1;
                    colZero[i] = 1;
                }
        for (i = 0; i < matrix.length; i++)
            for (j = 0; j < matrix[0].length; j++)
                if (rowZero[j] == 1 || colZero[i] == 1)
                    matrix[i][j] = 0;
        
    }
}
