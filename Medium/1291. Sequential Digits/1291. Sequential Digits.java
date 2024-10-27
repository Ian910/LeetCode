class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int digitLow = String.valueOf(low).length(), digitHigh = String.valueOf(high).length();
        String numStr = "123456789";
        for (int i = digitLow; i <= digitHigh; i++)
            for (int j = 0; j < 10 - i; j++) {
                digitLow = Integer.parseInt(numStr.substring(j, j + i));
                if (high >= digitLow && digitLow >= low) ans.add(digitLow);
            }
        return ans;
    }
}
