public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, start_i = 0;
        char curr;
        HashMap<Character, Integer> data_case = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            if (data_case.containsKey(curr)) {
                max = Math.max(max, (i - start_i));
                start_i = Math.max(start_i, data_case.get(curr) + 1);
            }
            data_case.put(curr, i);
        }
        return Math.max(s.length() - start_i, max);
    }
}
