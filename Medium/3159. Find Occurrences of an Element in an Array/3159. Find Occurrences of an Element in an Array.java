class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int curr = 0;
        for(int i = 0; i < nums.length; ++i) if (nums[i] == x) nums[curr++] = i;
        for(int i = 0; i < queries.length; ++i) { 
            x = queries[i];
            if (curr >= x) queries[i] = nums[x-1];
            else queries[i] = -1;
        }
        return queries;
    }
}