class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i = 1;
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (; i < nums.length; i++)
            ans[i] = nums[i - 1] * ans[i - 1];
        int mul = nums[nums.length - 1];
        for (i = nums.length - 2; i >= 0; i--) {
            ans[i] *= mul;
            mul *= nums[i];
        }
        return ans;
    }
}