public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int left = 0, right = nums.length - 1, mid, len = right;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while (left > 0 && nums[left - 1] == nums[mid])
                    left--;
                while (right < len && nums[right + 1] == nums[mid])
                    right++;
                res[0] = left;
                res[1] = right;
                break;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return res;
    }
}
