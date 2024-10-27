class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int maxBricksNeed = 0;
        for (int i = 0; i < heights.length - 1; i++)
            if (heights[i + 1] > heights[i]) maxBricksNeed += heights[i + 1] - heights[i];
        if (maxBricksNeed <= bricks) return heights.length-1;

        PriorityQueue<Integer> maxBricks = new PriorityQueue<>((a, b) -> (b - a));
        for (
            int i = 0;
            i < heights.length - 1; i++) {
            int num = heights[i + 1] - heights[i];
            if (num > 0) {
                maxBricks.offer(num);
                bricks -= num;
                if (bricks < 0) {
                    if (ladders > 0) {
                        bricks += maxBricks.poll();
                        ladders--;
                    } else return i;
                }
            }
        }
        return heights.length-1;
    }
}