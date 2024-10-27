class Solution {
    public int uniquePaths(int m, int n) {
        if(m > n) m = m + n - (n = m);
        if(m == 1) return 1;
        int[][] dp = new int[m - 1][n - 1];
        int i = 0, j;
        for (; i < n - 1; i++) dp[0][i] = i + 2;
        for (i = 1; i < m - 1; i++) {
            dp[i][i] = dp[i - 1][i] * 2;
            for (j = i + 1; j < n - 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 2][n - 2];
    }
    
}