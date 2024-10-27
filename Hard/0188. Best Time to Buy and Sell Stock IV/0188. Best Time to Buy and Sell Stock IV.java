class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] transactionRecords = new int[2 * k];
        for (int i = 0; i < 2 * k; i += 2)
            transactionRecords[i] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int currPrice = prices[i];

            int preState = 0;
            for (int times = 0; times < k; ++times) {
                transactionRecords[2 * times] = Math.max(transactionRecords[2 * times], preState - currPrice);
                transactionRecords[2 * times + 1] = Math.max(transactionRecords[2 * times + 1],
                        transactionRecords[2 * times] + currPrice);
                preState = transactionRecords[2 * times + 1];
            }
        }

        return transactionRecords[2 * k - 1];
    }
}