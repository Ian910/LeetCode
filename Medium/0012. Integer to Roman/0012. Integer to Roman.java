public class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        convert(result, num / 1000, "", "", "M");
        convert(result, num % 1000 / 100, "M", "D", "C");
        convert(result, num % 100 / 10, "C", "L", "X");
        convert(result, num % 10, "X", "V", "I");

        return result.toString();
    }

    void convert(StringBuilder result, int num, String max, String med, String min) {
        if (num == 9)
            result.append(min).append(max);
        else if (num == 4)
            result.append(min).append(med);
        else if (num == 5)
            result.append(med);
        else if (num > 4) {
            result.append(med);
            while (num-- > 5)
                result.append(min);
        } else
            while (num-- > 0)
                result.append(min);
    }
}