import java.util.*;

class Meeting {
    int start;
    int end;
    int index;

    public Meeting(int start, int end,int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class N_Meetings_One_Room {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.

    // sort based on meeting end time

    public int maxMeetings(int start[], int end[]) {
        // add your code here

        List<Meeting> meetings = new ArrayList<>();

        // update meetings list, require for sorting later by endtime

        for (int i=0;i<start.length;i++) {
            meetings.add(new Meeting(start[i],end[i],i)); // index of the meeting
        }

        // sort on the basis on endtime
        meetings.sort((a,b) -> a.end - b.end);

        // result list
        List<Integer> result = new ArrayList<>();
        // initiate last end for first meeting
        int lastEnd = -1;

        for (Meeting m: meetings) {
            if (m.start > lastEnd) {
                result.add(m.index);
                lastEnd = m.end;
            }
        }

        for (int i: result) {
            System.out.print(start[i] + " - " + end[i]);
            System.out.println("");
        }

        System.out.println("Total possible meetings: " + result.size());

        return result.size();
    }

    public static void main(String args[]) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        N_Meetings_One_Room nMeetingsOneRoom = new N_Meetings_One_Room();

        nMeetingsOneRoom.maxMeetings(start, end);
    }
}