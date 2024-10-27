class Solution {
    public boolean isValid(String s) {
        Stack<Character> record = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') record.push((char) (ch + 1));
            else if (ch == '[' || ch == '{') record.push((char) (ch + 2));
            else {
                if (record.isEmpty() || record.pop() != ch) return false;
            }
        }
        return record.isEmpty();
    }
}