class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] change = new int[n + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            change[i + 1] = Math.max(nums[i] - change[i], 0);
            count += change[i + 1];
        }
        return count;
    }
}