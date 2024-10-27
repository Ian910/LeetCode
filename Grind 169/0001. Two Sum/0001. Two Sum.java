class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(nums[i])) return new int[]{dict.get(nums[i]), i};
            else dict.put(target - nums[i], i);
        }
        return null;
    }
}