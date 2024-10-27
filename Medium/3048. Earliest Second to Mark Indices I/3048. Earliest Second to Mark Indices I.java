class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int low = 0, high = changeIndices.length - 1;
        for (int i = 0; i <= high; i++) changeIndices[i]--;
        while (low < high) {
            int mid = (low + high) / 2;
            if (isPossible(nums, changeIndices, mid)) high = mid;
            else low = mid + 1;
        }
        return isPossible(nums, changeIndices, low) ? low + 1 : -1;
    }

    private boolean isPossible(int[] nums, int[] changeIndices, int end) {
        int times = nums.length;
        int[] lastIndex = new int[times];
        for (int i = end; i >= 0; i--) {
            int num = changeIndices[i];
            if (lastIndex[num] == 0) {
                lastIndex[num] = i;
                if (--times == 0) break;
            }
        }
        if (times != 0) return false;

        for (int i = 0; i <= end; i++) {
            int num = changeIndices[i];
            if (i == lastIndex[num]) {
                times -= nums[num];
                if (times < 0) return false;
            } else times++;
        }
        return true;
    }
}