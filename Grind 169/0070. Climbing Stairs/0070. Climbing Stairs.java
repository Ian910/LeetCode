class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[]{1, 2};
        if (n <= 2) return dp[n - 1];
        int times = n - 2;
        while (times-- > 0) {
            int curr = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = curr;
        }
        return dp[1];
    }
}