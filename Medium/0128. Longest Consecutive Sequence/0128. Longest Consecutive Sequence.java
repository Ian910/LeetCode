class Solution {
    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        Arrays.sort(nums);
        int i = 1, ans = 1, temp = 1;
        for (; i < length; i++) {
            if (nums[i] == nums[i - 1] + 1) temp++;
            else if (nums[i] == nums[i - 1]) continue;
            else {
                ans = Math.max(ans, temp);
                temp = 1;
            }
        }
        return ans = Math.max(ans, temp);
    }
}