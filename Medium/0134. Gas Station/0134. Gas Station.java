class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1, sum = 0, i = 0;
        for (; i < gas.length; ++i) {
            gas[i] -= cost[i];

            if (sum == 0 && gas[i] >= 0) start = i;
            if (start == -1) continue;

            sum += gas[i];
            if (sum < 0) {
                sum = 0;
                start = i;
            }
        }

        if (start == -1) return -1;
        i = 0;
        while (i < start) {
            sum += gas[i++];
            if (sum < 0) return -1;
        }
        return start;
    }
}