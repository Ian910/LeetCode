class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
         int len = arr.length;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= arr.length; i++) {
            int temp = 0;
            for (int j = 1; i >= j && k >= j; j++) {
                temp = Math.max(temp, arr[i - j]);
                dp[i] = Math.max(dp[i - j] + temp * j, dp[i]);
            }
        }
        return dp[len];
    }
}