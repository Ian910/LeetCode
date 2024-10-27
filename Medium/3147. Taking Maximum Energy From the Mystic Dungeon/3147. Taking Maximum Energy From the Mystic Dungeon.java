class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int j = energy.length - 1 - i; j >= 0; j -= k) {
                sum += energy[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}