class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = nums[0] + nums[1], max = -1;
        int i = 2, len = nums.length;
        for (; i < len; i++) {
            if (sum > nums[i]) max = sum + nums[i];
            sum += nums[i];
        }
        return max;
    }
}