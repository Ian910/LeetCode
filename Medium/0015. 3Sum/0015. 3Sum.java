import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new AbstractList<List<Integer>>() {
            List<List<Integer>> res = null;

            public int size() {
                if (res == null)
                    init();
                return res.size();
            }

            public List<Integer> get(int index) {
                if (res == null)
                    init();
                return res.get(index);
            }

            private void init() {
                res = new ArrayList<>();
                Arrays.sort(nums);
                int i = 0, left, right, len = nums.length - 1;
                List<List<Integer>> ans = new LinkedList<>();
                for (; i <= len; i++) {
                    if (i > 0 && nums[i] == nums[i - 1])
                        continue;
                    left = i + 1;
                    right = len;
                    while (left < right) {
                        if (nums[left] + nums[right] + nums[i] == 0) {
                            res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                            while (left < len && nums[left] == nums[++left]);
                            while (right > 0 && nums[right] == nums[--right]);
                        } else if (nums[left] + nums[right] + nums[i] > 0)
                            right--;
                        else
                            left++;
                    }
                }
            }
        };
        return result;
    }
}
