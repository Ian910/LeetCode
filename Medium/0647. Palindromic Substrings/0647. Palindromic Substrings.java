class Solution {
    public int countSubstrings(String s) {
         int ct = 0;
        for (int i = 0; i < s.length(); i++) {
            ct = ct + process(s, i, i) + process(s, i - 1, i);
        }
        return ct;
    }

    public int process(String s, int left, int right) {
        final int len = s.length();
        int ct = 0;
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            ct++;
            left--;
            right++;
        }
        return ct;
    }
}