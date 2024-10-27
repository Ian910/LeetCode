class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        revPermute(0, nums, ans);
        return ans;
    }

    public void revPermute(int i, int[] nums, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) permutation.add(num);
            ans.add(permutation);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = nums[j] + nums[i] - (nums[i] = nums[j]);
            revPermute(i + 1, nums, ans);
            nums[j] = nums[j] + nums[i] - (nums[i] = nums[j]);
        }
    }
}