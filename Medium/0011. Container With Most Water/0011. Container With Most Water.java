public class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            max = height[left] <= height[right] ? Math.max(max, (right - left) * height[left++])
                    : Math.max(max, (right - left) * height[right--]);
        }
        return max;
    }
}