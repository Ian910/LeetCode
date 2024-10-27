class Solution {
    public int lengthOfLIS(int[] nums) {
        final int len = nums.length;
        int[] les = new int[len];
        int i = 0, j, max = 0;
        for (; i < len; i++) {
            les[i] = 1;
            for (j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    les[i] = Math.max(les[i], les[j] + 1);
            max = Math.max(max, les[i]);
        }
        return max;
    }
}
