public class Solution {
    public String longestPalindrome(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            sb.append("#");
        }
        String s = sb.toString();
        int[] p = new int[s.length()];
        int center = 0, right = 0, max = 0, max_right = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (i + p[i] + 1 < s.length() && i - p[i] - 1 >= 0 && s.charAt(i + p[i] + 1) == s.charAt(i - p[i] - 1)) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if (max < p[i]) {
                max = p[i];
                max_right = (right + 1) / 2;
            }
        }
        return str.substring(max_right - max, max_right);
    }
}
