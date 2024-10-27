class Solution {

    ArrayList<int[]> segments = new ArrayList<>();

    public int countDays(int days, int[][] meetings) {
    
        for (int[] meeting : meetings) {
            if (meeting[0] == 1 && meeting[1] == days) return 0;
            addMeeting(meeting[0], meeting[1]);
        }

        int[] currMeeting = segments.get(0);
        int noMeetingDays = currMeeting[0] - 1, currDay = currMeeting[1];

        for (int i = 1; i < segments.size(); ++i) {
            currMeeting = segments.get(i);
            if (currMeeting[0] > currDay) {
                noMeetingDays += currMeeting[0] - currDay - 1;
            }
            currDay = currMeeting[1];
        }
        return noMeetingDays + days - currDay;
    }
    
    private void addMeeting(int start, int end) {
        int size = segments.size();
        int[] newOne = new int[] { start, end };

        if (size == 0 || segments.get(size - 1)[1] < start) {
            segments.add(newOne);
            return;
        }

        if (end < segments.get(0)[0]) {
            segments.add(0, newOne);
            return;
        }
        
        int[] currMeeting;
        for (int i = 0; i < size; ++i) {
            currMeeting = segments.get(i);

            if (start > currMeeting[1]) {
                continue;
            } else if (end < currMeeting[0]) {
                segments.add(i, newOne);
                break;
            } else {
                currMeeting[0] = Math.min(currMeeting[0], start);
                currMeeting[1] = Math.max(currMeeting[1], end);
                checkNext(i);
                break;
            } 
        }
    }
    
    private void checkNext(int index) {
        int[] currMeeting = segments.get(index), otherMeetings;
        for (int i = segments.size() - 1; i >= index + 1; --i) {
            otherMeetings = segments.get(i);
            if (currMeeting[1] < otherMeetings[0]) continue;
            if (currMeeting[1] == otherMeetings[0]) {
                currMeeting[1] = otherMeetings[1];
                segments.remove(i);
            } else if (currMeeting[0] < otherMeetings[1]) {
                currMeeting[1] = Math.max(otherMeetings[1], currMeeting[1]);
                segments.remove(i);
            }
        }
    }
}