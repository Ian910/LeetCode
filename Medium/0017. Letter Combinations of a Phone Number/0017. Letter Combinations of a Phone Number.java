public class Solution {
    private String[] letter = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        return DFS(0, digits, new StringBuilder(), new ArrayList<>());
    }

    List<String> DFS(int num, String digits, StringBuilder sb, List<String> res) {
        if (num == digits.length()) {
            res.add(sb.toString());
            return res;
        }

        String digitLetter = letter[Character.getNumericValue(digits.charAt(num)) - 2];

        for (int i = 0; i < digitLetter.length(); i++) {
            DFS(num + 1, digits, sb.append(digitLetter.charAt(i)), res);
            sb.deleteCharAt(num);
        }
        return res;
    }
}
