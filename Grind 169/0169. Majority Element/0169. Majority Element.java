class Solution {
    public int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int times = 1;
            int curr = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                if (curr == nums[j]) ++times;
                else --times;

                if (times < 0) {
                    i = j - 1;
                    break;
                }
            }
            if (times > 0) return curr;
        }
        return -1;
    }
}