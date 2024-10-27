import java.util.AbstractList;
class Solution {
   public List<List<Integer>> combine(int maxNum, int maxFigures) {
        return new AbstractList<List<Integer>>() {

            private List<List<Integer>> result;

            private void dfs(int parentDepth, int maxNum, int maxFigures, List<List<Integer>> res, List<Integer> subset) {
                parentDepth += 1;

                if (parentDepth == maxNum) {
                    if (subset.size() == maxFigures) {
                        res.add(new ArrayList<Integer>(subset));
                    }
                } else {
                    dfs(parentDepth, maxNum, maxFigures, res, subset);
                    subset.add(parentDepth + 1);

                    dfs(parentDepth, maxNum, maxFigures, res, subset);
                    subset.remove(subset.size() - 1);
                }
            }

            public void init() {
                if (null != result) {
                    return;
                }
                result = new ArrayList<List<Integer>>();
                dfs(-1, maxNum, maxFigures, result, new ArrayList<Integer>());
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