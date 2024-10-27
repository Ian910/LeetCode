class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int len = intervals.length, size = 0;
        if (len == 0) return true;
        for (int i = 1; i < len; ++i) {
            int j = 0;
            int[] temp = intervals[i];
            for (; j <= size; ++j) if (intervals[j][0] > temp[0]) break;
            if (j != 0) if (temp[0] < intervals[j-1][1]) return false;
            if (j!= size) if (temp[1] > intervals[j+1][0]) return false;
            size += 1;
            for (int k = size; k > j; --k) intervals[k] = intervals[k-1];
            intervals[j] = temp;
        }
        return true;
    }
}