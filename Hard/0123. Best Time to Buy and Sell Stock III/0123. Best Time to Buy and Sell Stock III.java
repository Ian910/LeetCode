class Solution {
    public int maxProfit(int[] prices) {
        int buyTimes1 = -prices[0], sellTimes1 = 0;
        int buyTimes2 = buyTimes1, sellTimes2 = 0;

        for (int currPrice : prices) {
            buyTimes1 = Math.max(buyTimes1, -currPrice);
            sellTimes1 = Math.max(sellTimes1, buyTimes1 + currPrice);
            buyTimes2 = Math.max(buyTimes2, sellTimes1 - currPrice);
            sellTimes2 = Math.max(sellTimes2, buyTimes2 + currPrice);
        }

        return sellTimes2;
    }
}
