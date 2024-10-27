public class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        buildSB(n, n, new StringBuilder());
        return result;
    }

    void buildSB(int leaveOpenNum, int leaveCloseNum, StringBuilder sb) {
        if (leaveOpenNum == 0 && leaveCloseNum == 0) {
            result.add(sb.toString());
            return;
        }
        if (leaveOpenNum > leaveCloseNum || leaveOpenNum < 0)
            return;
        buildSB(leaveOpenNum - 1, leaveCloseNum, sb.append("("));
        sb.deleteCharAt(sb.length() - 1);
        buildSB(leaveOpenNum, leaveCloseNum - 1, sb.append(")"));
        sb.deleteCharAt(sb.length() - 1);
    }
}
