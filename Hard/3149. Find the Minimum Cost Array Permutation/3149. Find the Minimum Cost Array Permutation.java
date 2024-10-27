class Solution {
    int[][] tspDistance, tspNextPoint;

    public int[] findPermutation(int[] nums) {
        int n = nums.length;
        tspDistance = new int[1 << n][n];
        tspNextPoint = new int[1 << n][n];
        tsp(1, 0, nums);
        int[] res = new int[n];
        for (int i = 1, mask = 1, prev = 0; i < n; ++i) {
            res[i] = tspNextPoint[mask][prev];
            prev = res[i];
            mask = mask | (1 << prev);
        }
        return res;
    }

    private int tsp(int mask, int prev, int[] nums) {
        int n = nums.length;
        if (mask == (1 << n) - 1) return Math.abs(prev - nums[0]);
        if (tspDistance[mask][prev] != 0) return tspDistance[mask][prev];

        int minDistance = 200, nextPoint = 0;
        for (int next = 0, addMask = 1; next < n; ++next) {
            if ((mask & addMask) == 0) {
                int res = tsp(mask | addMask, next, nums) + Math.abs(prev - nums[next]);
                if (minDistance > res) {
                    minDistance = res;
                    nextPoint = next;
                }
            }
            addMask <<= 1;
        }
        tspNextPoint[mask][prev] = nextPoint;
        return tspDistance[mask][prev] = minDistance;
    }
}