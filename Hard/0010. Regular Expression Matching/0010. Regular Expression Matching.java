class Solution {
    public boolean isMatch(String s, String p) {
       dp = new Boolean[s.length()][p.length()];
        return isMatchHelper(0, s, 0, p);
    }

    private Boolean[][] dp;

    private boolean isMatchHelper(int sIdx, String s, int pIdx, String p) {
        if (sIdx == s.length()) {
            while (pIdx < p.length() && (p.charAt(pIdx) == '*' || (pIdx + 1 < p.length() && p.charAt(pIdx + 1) == '*')))
                pIdx++;
            return pIdx == p.length();
        }
        if (sIdx < s.length() && pIdx == p.length()) return false;
        if (dp[sIdx][pIdx] != null) return dp[sIdx][pIdx];


        char pChar = p.charAt(pIdx);
        char sChar = s.charAt(sIdx);

        boolean res = false;

        if (pChar != '*') {
            if (pChar == '.' || pChar == sChar) res = res || isMatchHelper(sIdx + 1, s, pIdx + 1, p);
            if (pIdx < p.length() - 1 && p.charAt(pIdx + 1) == '*') res = res || isMatchHelper(sIdx, s, pIdx + 1, p);
        } else {
            if (pIdx > 0) {
                char pPreChar = p.charAt(pIdx - 1);
                if (sChar == pPreChar || pPreChar == '.') {
                    res = res || isMatchHelper(sIdx + 1, s, pIdx, p);
                    res = res || isMatchHelper(sIdx + 1, s, pIdx + 1, p);
                }
            }
            res = res || isMatchHelper(sIdx, s, pIdx + 1, p);
        }

        dp[sIdx][pIdx] = res;
        return res;
    }
}