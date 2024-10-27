public class Solution {
    public List<List<Integer>> fourSum(int[] nums, long target) {
        Arrays.sort(nums);
        int i, j, left, right, len = nums.length - 1, sum;
        List<List<Integer>> result = new LinkedList<>();
        if (nums[0] > target / 4 || target / 4 > nums[len])
            return result;

        for (i = 0; i <= len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (j = i + 1; j <= len - 2; j++) {
                left = j + 1;
                right = len;
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (left < right) {
                    sum = nums[left] + nums[right] + nums[i] + nums[j];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < len && nums[left] == nums[++left])
                            ;
                        while (right > 0 && nums[right] == nums[--right])
                            ;
                    } else if (sum > target) {
                        right--;
                        while (right > 0 && nums[right + 1] == nums[right])
                            right--;
                    } else {
                        left++;
                        while (left < len && nums[left - 1] == nums[left])
                            left++;
                    }
                }
            }
        }
        return result;
    }
}
