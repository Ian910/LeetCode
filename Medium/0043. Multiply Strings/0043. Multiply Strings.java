class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length(), len2 = num2.length(), i, j;
        int[] sum = new int[len1 + len2];

        for (i = len1 - 1; i >= 0; i--) {
            for (j = len2 - 1; j >= 0; j--){
                sum[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                sum[i + j] += sum[i + j + 1] / 10;
                sum[i + j + 1] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        i = sum[0] == 0 ? 1 : 0;
        for (; i < sum.length; i++) sb.append(sum[i]);
        return sb.toString();

    }
}