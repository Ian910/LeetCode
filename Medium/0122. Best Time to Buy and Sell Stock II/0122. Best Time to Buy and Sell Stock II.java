class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = prices[0];
        for (int num : prices) {
            if (min > num)
                min = num;
            else {
                max += num - min;
                min = num;
            }
        }
        return max;
    }
}