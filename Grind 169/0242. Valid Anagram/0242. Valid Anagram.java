class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charRecords = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            charRecords[s.charAt(i) - 'a']++;
            charRecords[t.charAt(i) - 'a']--;
        }
        for (int record : charRecords) if (record != 0) return false;
        return true;
    }
}