public class Solution {
    public int myAtoi(String s) {
        int sign = 0, i = 0, len = s.length(), num = 0;

        while (i < len) {
            if (s.charAt(i) == ' ' && sign == 0);
            else if ((s.charAt(i) == '-' || s.charAt(i) == '+') && sign == 0) sign = s.charAt(i) - 44;
            else if ('0' <= s.charAt(i) && s.charAt(i) <= '9') break;
            else return 0;
            i++;
        }

        while (i < len) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && s.charAt(i) >= '8')) {
                    return sign != 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num * 10 + (s.charAt(i) - '0');
            } else break;
            i++;
        }
        return sign != 1 ? num : -num;
    }
}