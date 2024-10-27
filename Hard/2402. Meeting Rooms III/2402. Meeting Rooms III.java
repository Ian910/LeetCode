class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int startTimeMax = 0, i, currTime = 0, maxValue = Integer.MAX_VALUE - 500000;
        int[][] room = new int[n][2];
        for (i = 0; i < meetings.length; ++i) if (meetings[i][0] > startTimeMax) startTimeMax = meetings[i][0];

        int[] scheduleTime = new int[startTimeMax + 1];
        for (i = 0; i < meetings.length; ++i) scheduleTime[meetings[i][0]] = meetings[i][1];

        for (i = 0; i <= startTimeMax; ++i) {
            if (scheduleTime[i] == 0) continue;
            if (currTime < i) currTime = i;

            int selectRoomNo = 0;
            for (int j = 1; j < n; ++j) {
                if (currTime >= room[selectRoomNo][1]) break;
                else if (room[selectRoomNo][1] > room[j][1]) selectRoomNo = j;
            }

            if (currTime > maxValue) {
                int target = room[selectRoomNo][1];
                for (int j = 0; j < n; ++j) room[j][1] -= target;
                currTime = i;
            } else if (currTime < room[selectRoomNo][1]) currTime = room[selectRoomNo][1];
            room[selectRoomNo][1] = currTime + scheduleTime[i] - i;
            ++room[selectRoomNo][0];
        }

        int ans = 0;
        for (i = 0; i < n; ++i) if (room[i][0] > room[ans][0]) ans = i;
        return ans;
    }
}