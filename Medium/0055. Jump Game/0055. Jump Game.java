class Solution {
    public boolean canJump(int[] nums) {
        int last = 0, step = 0, next = 0, len = nums.length;
        while (step < len - 1) {
            for (int i = last; i <= step; i++) {
                if (i + nums[i] > next) next = i + nums[i];
            }
            last = step;
            step = next;
            if (step == last) return false;
        }
        return true;
    }
}