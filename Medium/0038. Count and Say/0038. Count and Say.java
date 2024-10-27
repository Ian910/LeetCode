public class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        char c;
        int i, j, ct;
        for (i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            ct = 1;
            c = ans.charAt(0);
            for (j = 1; j < ans.length(); j++) {
                if (c == ans.charAt(j))
                    ct++;
                else {
                    sb.append(ct).append(c);
                    c = ans.charAt(j);
                    ct = 1;
                }
            }
            sb.append(ct).append(c);
            ans = sb.toString();
        }
        return ans;
    }
}