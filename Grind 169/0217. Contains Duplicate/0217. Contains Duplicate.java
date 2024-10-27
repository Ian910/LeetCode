class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> data = new HashSet<>();
        for (int num : nums) if (!data.add(num)) return true;
        return false;
    }
}