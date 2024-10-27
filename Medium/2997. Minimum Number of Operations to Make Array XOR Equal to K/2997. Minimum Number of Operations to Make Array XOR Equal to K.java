class Solution {
    public int minOperations(int[] nums, int k) {
        for(int num: nums) k ^= num;
        int ans = 0;
        while (k != 0) {
            k &= (k-1);
            ++ans;
        }
        return ans;
    }
}