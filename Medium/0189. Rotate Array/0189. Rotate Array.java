class Solution {
    public void rotate(int[] nums, int k) {
        k = nums.length - k % nums.length;
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    void reverse(int[] nums, int st, int ed) {
        while (st < ed) {
            nums[st] = nums[ed] + nums[st] - (nums[ed] = nums[st]);
            st++;
            ed--;
        }
    }
}