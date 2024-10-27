class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
       int max = nums1[0], min = max;
        for (int number : nums1) {
            if (min > number) min = number;
            else if (max < number) max = number;
        }

        int[] record = new int[max - min + 1];
        for (int number : nums2) {
            int interval = number *= k;
            number *= (min / number  + (min % number == 0 ? 0 : 1));
            while (max >= number) {
                record[number - min]++;
                number += interval;
            }
        }

        long answer = 0;
        for (int number : nums1) answer += record[number - min];
        return answer;
    }
}