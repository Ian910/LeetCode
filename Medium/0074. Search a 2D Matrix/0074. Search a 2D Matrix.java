class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       final int row = matrix.length, col = matrix[0].length;
       int i, j;
       for (i = 0; i < row; i++)
           if (matrix[i][0] <= target && target <= matrix[i][col - 1])
               return search(target, 0, col - 1, matrix[i]);
       return false;
   }

   public boolean search(int target, int left, int right, int[] matrix) {
       int mid;
       while (left <= right) {
           mid = (left + right) / 2;
           if (matrix[mid] == target) return true;
           if (matrix[mid] < target) left = mid + 1;
           else right = mid - 1;
       }
       return false;
   }
}
