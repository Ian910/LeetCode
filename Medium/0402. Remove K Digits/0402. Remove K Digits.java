class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";

        StringBuilder sb = new StringBuilder(num);
        int curr = 0;

        while (k-- > 0) {
           while (curr < sb.length() - 1 && sb.charAt(curr) <= sb.charAt(curr + 1)) ++curr;
            if (curr == sb.length()) {
                sb.delete(curr - k - 1, curr);
                break;
            }
            sb.delete(curr, curr + 1);
            if (curr > 0) --curr;
        }

        curr = 0;
        while (curr < sb.length() - 1 && sb.charAt(curr) == '0') curr++;
        return sb.toString().substring(curr);
    }
}