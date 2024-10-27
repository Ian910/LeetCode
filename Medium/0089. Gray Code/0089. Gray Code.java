class Solution {
    public List<Integer> grayCode(int n) {
        n = (int) Math.pow(2, n);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}
