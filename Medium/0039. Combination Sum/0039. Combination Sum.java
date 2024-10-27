class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> smallSet = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Backtracking(candidates, target, 0);
        return ans;
    }

    public void Backtracking(int[] c, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(smallSet));
            return;
        }

        for (int i = start; i < c.length; i++) {
            if (c[i] <= target) {
                smallSet.add(c[i]);
                Backtracking(c, target - c[i], i);
                smallSet.remove(smallSet.size() - 1);
            }
        }
    }
}