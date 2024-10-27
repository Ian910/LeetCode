class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        fillColor(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void fillColor(int[][] image, int sr, int sc, int color, int change) {
        if (image[sr][sc] != change) return;
        image[sr][sc] = color;
        if (sr > 0) fillColor(image, sr - 1, sc, color, change);
        if (sr < image.length - 1) fillColor(image, sr + 1, sc, color, change);
        if (sc > 0) fillColor(image, sr, sc - 1, color, change);
        if (sc < image[0].length - 1) fillColor(image, sr, sc + 1, color, change);
    }
}