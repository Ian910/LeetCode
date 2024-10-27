class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] character = new int[26];
        int len1 = ransomNote.length(), len2 = magazine.length();
        for (int i = 0; i < len1; ++i) {
            character[magazine.charAt(i) - 'a']++;
            character[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = len1; i < len2; ++i) character[magazine.charAt(i) - 'a']++;

        for (int times : character) if (times < 0) return false;
        return true;
    }
}