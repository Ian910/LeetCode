class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length, i = 0, curr = 0;

        while (i < len) {
            nums[curr++] = nums[i++];
            if (i == len) break;
            if (i < len && nums[i] == nums[i - 1]) {
                nums[curr++] = nums[i++];
            }
            if (i == len) break;
            while (i < len && nums[i - 1] == nums[i]) {
                i++;
            }
            if (i == len) break;
        }
        return curr;
    }
}
