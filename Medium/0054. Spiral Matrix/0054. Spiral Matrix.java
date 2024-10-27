class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, left = 0, bottom = matrix.length, right = matrix[0].length, i;
        while (top < bottom && left < right) {
            for (i = left; i < right; i++) ans.add(matrix[top][i]);
            top++;
            for (i = top; i < bottom; i++) ans.add(matrix[i][right - 1]);
            right--;
            if (top == bottom || left == right) break;
            for (i = right - 1; i >= left; i--) ans.add(matrix[bottom - 1][i]);
            bottom--;
            for (i = bottom - 1; i >= top; i--) ans.add(matrix[i][left]);
            left++;
        }
        return ans;
    }
}