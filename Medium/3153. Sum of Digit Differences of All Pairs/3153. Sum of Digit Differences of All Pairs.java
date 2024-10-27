class Solution {
    public long sumDigitDifferences(int[] nums) {
        int maxDigitNum = String.valueOf(nums[0]).length();
        int[][] digitRecords = new int[maxDigitNum][10];
        long result = ((long) nums.length * (nums.length - 1)) / 2 * maxDigitNum;
        for (int num : nums) {
            maxDigitNum = 0;
            while (num > 0) {
                result -= digitRecords[maxDigitNum++][num % 10]++;
                num /= 10;
            }
        }

        return result;
    }
}