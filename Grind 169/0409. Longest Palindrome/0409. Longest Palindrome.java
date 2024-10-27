class Solution {
    public int longestPalindrome(String s) {
       int[] character = new int[52];
        for (char ch : s.toCharArray())
            if (ch >= 'a') character[ch - 'a']++;
            else character[ch - 'A' + 26]++;

        int ans = 0, leave = 0;
        for (int times : character) {
            ans += times / 2;
            if (leave == 0 && times % 2 == 1) ++leave;
        }
        return (ans << 1) + leave; 
    }
}