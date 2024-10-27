class Solution {
    public int romanToInt(String s) {
        int curr = -1, sum = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            int num = getValue(s.charAt(i));
            if (num >= curr) curr = num;
            else num = -num;
            sum += num;
        }
        return sum;
    }

    private int getValue(char ch) {
        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;
        return 1000;
    }
}