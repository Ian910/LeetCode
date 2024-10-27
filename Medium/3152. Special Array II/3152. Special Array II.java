class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int totalCorrespondCount = 1;
        boolean preState = nums[0] % 2 == 0;
        nums[0] = totalCorrespondCount;

        for (int i = 1; i < nums.length; ++i) {
            boolean temp = nums[i] % 2 == 0;
            if (temp != preState)
                ++totalCorrespondCount;
            nums[i] = totalCorrespondCount;
            preState = temp;
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            result[i] = queries[i][1] - queries[i][0] == nums[queries[i][1]] - nums[queries[i][0]];
        }

        return result;
    }
}