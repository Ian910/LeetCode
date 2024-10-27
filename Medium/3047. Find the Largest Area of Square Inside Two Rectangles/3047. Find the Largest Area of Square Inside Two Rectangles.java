class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int rectangleNum = bottomLeft.length;
        long ans = 0;
        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = i + 1; j < rectangleNum; j++) {
                int lenX = Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int lenY = Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                if (lenX > 0 && lenY > 0) ans = Math.max(ans, Math.min(lenX, lenY));
            }
        }
        return ans * ans;
    }
}