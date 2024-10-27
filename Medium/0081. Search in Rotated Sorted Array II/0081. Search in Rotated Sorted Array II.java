class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        if (target < nums[0] && target > nums[right]) return false;
        while (left <= right) {
            while (left < right && nums[left] == nums[left + 1]) left++;
            while (right > left && nums[right] == nums[right - 1]) right--;
            mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }

        }
        return false;
    }
}
