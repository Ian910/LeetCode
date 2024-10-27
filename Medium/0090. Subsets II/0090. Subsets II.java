import java.util.AbstractList;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] numsTidy = new int[21], numsUse = new int[21];
        for (int num : nums) numsTidy[num + 10]++;
        return new AbstractList<List<Integer>>() {

            private List<List<Integer>> result;
            private final int len = nums.length;

            private void dfs(int parentDepth) {
                if (parentDepth == 21) {
                    List<Integer> subset = new ArrayList<>();
                    for (int i = 0; i < 21; i++) {
                        for (int j = 0; j < numsUse[i]; j++) {
                            subset.add(i - 10);
                        }
                    }
                    result.add(subset);
                    return;
                }
                for (int i = 0; i <= numsTidy[parentDepth]; i++) {
                    numsUse[parentDepth] = i;
                    dfs(parentDepth + 1);
                }
                numsUse[parentDepth] = 0;
            }

            public void init() {
                if (null != result) {
                    return;
                }
                result = new ArrayList<List<Integer>>();
                dfs(0);
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