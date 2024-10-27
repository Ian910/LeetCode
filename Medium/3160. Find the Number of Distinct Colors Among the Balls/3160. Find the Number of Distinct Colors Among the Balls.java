class Solution {
    public int[] queryResults(int limit, int[][] queries) {
                int i = 0;
        int[] ans = new int[queries.length];
        Map<Integer, Integer> ballColors = new HashMap<>();
        Map<Integer, Integer> colorCounts = new HashMap<>();
        for (int[] query : queries) {
            int ball = query[0];
            int currColor = query[1];
            if (ballColors.containsKey(ball)) {
                int prevColor = ballColors.get(ball);
                int prevColorCounts = colorCounts.get(prevColor) - 1;
                if (prevColorCounts == 0) colorCounts.remove(prevColor);
                else colorCounts.put(prevColor, prevColorCounts);
            }
            ballColors.put(ball, currColor);
            colorCounts.put(currColor, colorCounts.getOrDefault(currColor, 0) + 1);
            ans[i++] = colorCounts.size();
        }
        return ans;
    }
}