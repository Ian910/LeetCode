public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i, left, right, temp, len = nums.length - 1, min = Integer.MAX_VALUE;

        if (nums[len] + nums[len-1] + nums[len-2] <= target) return nums[len] + nums[len-1] + nums[len-2];
        if (nums[0] + nums[1] + nums[2] >= target) return nums[0] + nums[1] + nums[2];

        for (i = 0; i < len - 1; i++) {
            left = i + 1;
            right = len;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == target) {
                    return target;
                } else if (nums[i] + nums[left] + nums[right] > target) {
                    min = Math.abs(min - target) < Math.abs(nums[i] + nums[left] + nums[right] - target) ? min : nums[i] + nums[left] + nums[right];
                    --right;
                } else {
                    min = Math.abs(min - target) < Math.abs(nums[i] + nums[left] + nums[right] - target) ? min : nums[i] + nums[left] + nums[right];
                    ++left;
                }
            }
        }

        return min;
    }
}
