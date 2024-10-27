class Solution {
    public int maxProfit(int[] prices) {
        int state1 = -prices[0], state2 = 0;
        for (int num : prices) {
            state1 = Math.max(state1, -num);
            state2 = Math.max(state2, num + state1);
        }
        return state2;
    }
}