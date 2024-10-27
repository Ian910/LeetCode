class Solution {
    public int numSquares(int n) {
        int pow = (int) Math.sqrt(n);
        if (pow * pow == n)
            return 1;
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (; pow > 0; pow--) {
            int temp = (int) Math.sqrt(n - pow * pow);
            if (temp * temp + pow * pow == n)
                return 2;
        }
        return 3;
    }
}