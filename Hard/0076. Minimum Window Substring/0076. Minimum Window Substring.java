class Solution {
    public String minWindow(String s, String t) {
        final int len1 = s.length(), len2 = t.length();
        if (s.equals(t)) return t;
        if (len1 < len2 || len2 == 0) return "";

        int[] freq = new int[128];
        for (char c : t.toCharArray()) ++freq[c];
        int ansLeft = 0, ansRight = len1 + 1;

        for (int curr = 0, indexS = 0, ct = len2; indexS < len1; ++indexS) {
            if (--freq[s.charAt(indexS)] >= 0) --ct;
            while (ct == 0) {
                if (indexS - curr + 1 < ansRight) {
                    ansRight = indexS - curr + 1;
                    ansLeft = curr;
                }
                // 第1個為t所含有的字元，可能會重複，例如：aaa...，但是在--freq那邊就會過濾了
                // 另外非t所含有的字元，freq 最大值只會等於0，也是因為--freq
                if (++freq[s.charAt(curr++)] == 1) ++ct;
            }
        }
        return ansRight == len1 + 1 ? "" : s.substring(ansLeft , ansLeft  + ansRight);
    }
}