class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        int i = 2, j;
        dp[0] = 1;
        dp[1] = 1;

        for (; i <= n; i++)
            for (j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - j - 1];
        return dp[n];
    }
}