class Solution {
    public int longestIdealString(String s, int k) {
        int len = s.length();
        int[] characterData = new int[26];
        for (int i = 0; i < len; ++i) {
            int currChar = s.charAt(i) - 'a', currLength = 1;
            for (int j = Math.max(currChar - k, 0); j <= 25 && j <= currChar + k; ++j)
                currLength = Math.max(currLength, characterData[j] + 1);
            characterData[currChar] = currLength;
        }

        int ans = 0;
        for (int num : characterData) if (num > ans) ans = num;
        return ans;
    }
}