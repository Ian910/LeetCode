class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len1 = triangle.size(), i = 1, j;

        for (; i < len1; i++) {
            triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
            triangle.get(i).set(i, triangle.get(i - 1).get(i - 1) + triangle.get(i).get(i));
            for (j = 1; j < i; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)) + triangle.get(i).get(j));
            }
        }

        int min = triangle.get(len1 - 1).get(0);
        for (int num : triangle.get(len1 - 1)) min = Math.min(num, min);
        return min;
    }
}
