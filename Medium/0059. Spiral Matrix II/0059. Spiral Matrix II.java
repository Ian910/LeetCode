class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int ct = 1, top = 0, bottom = n, left = 0, right = n, i;
        while (left < right && top < bottom) {
            for (i = left; i < right; i++) ans[top][i] = ct++;
            top++;
            for (i = top; i < bottom; i++) ans[i][right - 1] = ct++;
            right--;
            if (top == bottom || left == right) break;
            for (i = right - 1; i >= left; i--) ans[bottom - 1][i] = ct++;
            bottom--;
            for (i = bottom - 1; i >= top; i--) ans[i][left] = ct++;
            left++;
        }
        return ans;
    }
}