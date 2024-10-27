import java.util.AbstractList;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return new AbstractList<Integer>() {
            List<Integer> ans = null;

            @Override
            public Integer get(int index) {
                if (ans == null) init();
                return ans.get(index);
            }

            @Override
            public int size() {
                if (ans == null) init();
                return ans.size();
            }

            public void init() {
                ans = new ArrayList<>();
                int len = nums.length, max = 0;

                int[][] dp = new int[len][2];
                for (int i = 0; i < len; i++) {
                    dp[i][0] = 1;
                    dp[i][1] = -1;
                    int temp = 0, tempIndex = -1;
                    for (int j = i - 1; j >= 0; j--)
                        if (nums[i] % nums[j] == 0 && temp < dp[j][0] + 1) {
                            temp = dp[j][0] + 1;
                            tempIndex = j;
                        }

                    dp[i] = tempIndex == -1 ? new int[]{1, -1} : new int[]{temp, tempIndex};
                    if (dp[i][0] > dp[max][0]) max = i;
                }

                while (dp[max][1] != -1) {
                    ans.add(nums[max]);
                    max = dp[max][1];
                }
                ans.add(nums[max]);
            }
        };
    }
}