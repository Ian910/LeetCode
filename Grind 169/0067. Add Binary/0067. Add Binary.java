class Solution {
    public String addBinary(String a, String b) {
        if (b.length() > a.length()) return addBinaryProcess(b, a);
        else return addBinaryProcess(a, b);
    }

    private String addBinaryProcess(String max, String min) {
        char[] temp = max.toCharArray();
        int indexMax = temp.length - 1, indexMin = min.length() - 1, carry = 0;
        for (; indexMax >= 0 && indexMin >= 0; --indexMax, --indexMin) {
            int num = temp[indexMax] - '0' + min.charAt(indexMin) - '0' + carry;
            carry = num / 2;
            temp[indexMax] = (char) (num % 2 + '0');
        }
        while (indexMax >= 0 && carry == 1) {
            int num = temp[indexMax] - '0' + carry;
            carry = num / 2;
            temp[indexMax--] = (char) (num % 2 + '0');
        }
        return (carry == 1 ? '1' : "") + new String(temp);
    }
}