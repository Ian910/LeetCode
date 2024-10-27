class Solution {
    public int waysToReachStair(int k) {
        int upStairCount = 1, power = 1, res = 0;
        while ((upStairCount - 1) + (-power) <= (k - 1)) {
            if ((upStairCount - 1) >= (k - 1)) {
                res += calculateCombination(power, upStairCount - k);
            }
            upStairCount <<= 1;
            power++;
        }

        return res;
    }

    private int calculateCombination(int num1, int num2) {
        if (num1 == num2 || num2 == 0)
            return 1;
        if (num2 == 1)
            return num1;
        if (num1 - 2 * num2 < 0)
            return calculateCombination(num1, num1 - num2);
        int times = num2;
        long res = 1L;
        num1 = num1 - times + 1;
        num2 = 1;
        while (times-- > 0)
            res = res * num1++ / num2++;
        return (int) res;
    }
}