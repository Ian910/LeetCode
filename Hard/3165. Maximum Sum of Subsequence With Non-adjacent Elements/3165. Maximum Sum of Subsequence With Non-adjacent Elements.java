class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        long res = 0;
        int len = nums.length, sum = 0;
        int[] changes = new int[len + 1];
        for (int i = 0; i < len; ++i) sum += changes[i + 1] = Math.max(nums[i] - changes[i], 0);

        for (int[] query : queries) {
            int index = query[0];
            nums[index] = query[1];
            while (index < len) {
                int changeDiff = Math.max(nums[index] - changes[index], 0) - changes[index + 1];
                if (changeDiff == 0) break;
                sum += changeDiff;
                changes[++index] += changeDiff;
            }
            res = (res + sum) % 1000000007;
        }

        return (int) res;
    }
}