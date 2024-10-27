class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, len = nums.length;
        if (len % 3 != 0) return new int[][]{};
        int[][] ans = new int[len / 3][];
        for (; i < len; i += 3) {
            if (nums[i + 2] - nums[i] > k) return new int[][]{};
            ans[j++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}