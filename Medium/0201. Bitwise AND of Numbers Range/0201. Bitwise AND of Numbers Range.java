class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0 || left == right) return left;
        if (right / left > 2) return 0;

        int ans = 0;
        for (int i = 30; i > 0; i--) {
            int num = (right >> i);
            if (left >> i != num) return ans;
            else if(num != 0) ans = (num << i);
        }
        return ans;
    }
}
