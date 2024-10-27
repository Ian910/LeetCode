import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        return new AbstractList<String>() {
            List<String> res = null;

            public int size() {
                if (res == null) init();
                return res.size();
            }

            public String get(int index) {
                if (res == null) init();
                return res.get(index);
            }

            private void init() {
                res = new ArrayList<>();
                backtracking(s, "", 0);
            }

            private void backtracking(String str, String sub, int times) {
                if (times == 4) {
                    res.add(sub);
                    return;
                }
                int num = 0;
                if (times != 0) sub += '.';
                for (int i = 1; i < 4 && i <= str.length(); i++) {
                    num = num * 10 + (str.charAt(i - 1) - '0');
                    if (num == 0) {
                        if (times == 3 && str.length() != 1) return;
                        backtracking(str.substring(1), sub + '0', times + 1);
                        return;
                    } else if (str.length() > 3 * (3 - times) + i || num > 255) continue;
                    else if (times != 3 && str.length() - i < 1) return;
                    else {
                        backtracking(str.substring(i), sub + str.substring(0, i), times + 1);
                    }
                }
            }
        };
    }
}