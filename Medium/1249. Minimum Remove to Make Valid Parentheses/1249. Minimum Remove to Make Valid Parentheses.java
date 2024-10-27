class Solution {
    public String minRemoveToMakeValid(String s) {
         StringBuilder sb = new StringBuilder(s), ans = new StringBuilder();
        int i = 0, lb = 0, ct = 0;

        while (i < sb.length()) {
            char temp = sb.charAt(i);
            if (temp == '(') lb++;
            else if (temp == ')') {
                if (lb > 0) lb--;
                else sb.setCharAt(i, '*');
            }
            i++;
        }

        while (--i >= 0 && lb > 0) {
            char temp = sb.charAt(i);
            if (temp == '(') {
                sb.setCharAt(i, '*');
                --lb;
            }
        }

        for (i = 0; i < sb.length(); ++i) {
            char temp = sb.charAt(i);
            if (temp != '*') ans.append(temp);
        }

        return ans.toString();
    }
}