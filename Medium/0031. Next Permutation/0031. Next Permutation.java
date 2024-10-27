public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        int len = nums.length, switch_i, i;
        Boolean isSwap = false;
        for (switch_i = len - 1; switch_i >= 0; switch_i--) {
            if (switch_i == 0 || nums[switch_i - 1] < nums[switch_i]) {
                switch_i--;
                break;
            }
        }

        for (i = len - 1; i >= (len + switch_i + 1) / 2; i--) {
            if (!isSwap && switch_i >= 0 && nums[i] > nums[switch_i]) {
                isSwap = true;
                nums[switch_i] = nums[switch_i] + nums[i] - (nums[i] = nums[switch_i]);
            }
            nums[switch_i + len - i] = nums[switch_i + len - i] + nums[i] - (nums[i] = nums[switch_i + len - i]);
        }

        if (!isSwap && switch_i >= 0) {
            i = switch_i + (len - switch_i - 1) / 2;
            while (nums[i] <= nums[switch_i])
                i++;
            nums[switch_i] = nums[switch_i] + nums[i] - (nums[i] = nums[switch_i]);
        }
    }
}
