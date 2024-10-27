import java.util.AbstractList;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return new AbstractList<List<Integer>>() {

            private List<List<Integer>> result;

            private void dfs(int parentDepth, List<Integer> subset) {
                parentDepth += 1;

                if (parentDepth == nums.length) {
                    result.add(new ArrayList<Integer>(subset));
                } else {
                    dfs(parentDepth, subset);
                    subset.add(nums[parentDepth]);

                    dfs(parentDepth, subset);
                    subset.remove(subset.size() - 1);
                }
            }

            public void init() {
                if (null != result) {
                    return;
                }
                result = new ArrayList<List<Integer>>();
                dfs(-1, new ArrayList<Integer>());
            }

            @Override
            public int size() {
                init();
                return result.size();
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return result.get(index);
            }
        };
    }
}