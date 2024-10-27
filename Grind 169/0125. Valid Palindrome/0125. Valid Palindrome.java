class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int left = 0, right = len - 1; left < right; left++, right--) {
            char charLeft = s.charAt(left);
            while (!((charLeft <= 'Z' && charLeft >= 'A') || (charLeft <= 'z' && charLeft >= 'a') || (charLeft <= '9' && charLeft >= '0')))
                if (++left >= len) break;
                else charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            while (!((charRight <= 'Z' && charRight >= 'A') || (charRight <= 'z' && charRight >= 'a') || (charRight <= '9' && charRight >= '0')))
                if (--right <= 0) break;
                else charRight = s.charAt(right);
            if (left >= right) break;
            if (charLeft >= 'a') charLeft -= 32;
            if (charRight >= 'a') charRight -= 32;
            if (charLeft != charRight) return false;
        }
        return true;
    }
}