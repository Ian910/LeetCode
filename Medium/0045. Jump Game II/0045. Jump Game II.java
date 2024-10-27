class Solution {
    public int jump(int[] nums) {
        int step = 0, count = 0, next = 0, last = 0;
        for (; step < nums.length - 1; count++) {
            for (int i = last; i <= step; i++) if (i + nums[i] > next) next = i + nums[i];
            last = step;
            step = next;
        }
        return count;
    }
}