public class Solution {
    public int divide(int dividend, int divisor) {

        if (divisor == 1)
            return dividend;
        if (divisor == -1) {
            if (Integer.MIN_VALUE == dividend)
                return Integer.MAX_VALUE;
            else
                return -dividend;
        }

        Boolean mark = dividend < 0 ^ divisor < 0;
        // MAX_VALUE ~ MIN_VALUE+1 都為正數，MIN_VALUE 保持原樣
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int ct = -1, res = 0;

        // 狀況1：一般 被除數大於除數
        // 狀況2：被除數為 MIN_VALUE 被除數(MIN_VALUE) - 除數(皆為正) 必大於0
        // 狀況3：除數為 MIN_VALUE 被除數(自然數) - 除數(MIN_VALUE) 必小於0
        if (dividend - (divisor) >= 0) {

            // 狀況1：一般 若大於被除數就不繼續做
            // 狀況2：被除數為 MIN_VALUE 被除數(MIN_VALUE) - 除數(皆為正) 必大於0
            // 狀況3：皆為 MIN_VALUE 被除數(MIN_VALUE) - 0 必小於0
            for (ct = 0; dividend - (divisor << ct << 1) > 0; ct++);
        }

        while (ct >= 0) {
            while (dividend - (divisor << ct) >= 0) {
                res += 1 << ct;
                dividend -= divisor << ct;
            }
            ct--;
        }
        return mark ? -res : res;
    }
}