class Solution {
    public String compressedString(String word) {
                StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length();) {
            int same = 1;
            char curr = word.charAt(i++);
            while(i < word.length() && word.charAt(i) == curr && same < 9) {
                ++i;
                ++same;
            }
            sb.append(same).append(curr);
        }
        return sb.toString();
    }
}