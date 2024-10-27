class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : target.toCharArray()) {
            sb.append('a');
            ans.add(sb.toString());

            for (int i = 1; i <=  ch - 'a'; i++) {
                sb.setCharAt(sb.length() - 1, (char) ( 'a' + i));
                ans.add(sb.toString());
            }
        }

        return ans;
    }
}