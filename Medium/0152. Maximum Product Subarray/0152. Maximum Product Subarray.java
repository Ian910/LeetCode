class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], max = ans, min = ans, curr;
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i];
            if (curr < 0)
                max = (max + min) - (min = max);
            min = Math.min(curr * min, curr);
            max = Math.max(curr * max, curr);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}