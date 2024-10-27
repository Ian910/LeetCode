class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, area = 0;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[++left]);
                area += leftMax - height[left];
            } else {
                rightMax = Math.max(rightMax, height[--right]);
                area += rightMax - height[right];
            }
        }
        return area;
    }
}