class Solution {
    public void sortColors(int[] nums) {
        mergeSort(new int[nums.length], nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] temp, int[] nums, int left, int right) {
        if (left < right) {
            int i = left, mid = (left + right) / 2, j = mid + 1, index = 0;
            mergeSort(temp, nums, left, mid);
            mergeSort(temp, nums, j, right);
            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) temp[index++] = nums[i++];
                else temp[index++] = nums[j++];
            }
            while (i <= mid) temp[index++] = nums[i++];
            for (i = left; i < j; i++)
                nums[i] = temp[i - left];
        }

    }
}
