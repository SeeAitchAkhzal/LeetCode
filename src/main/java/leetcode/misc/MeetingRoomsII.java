package leetcode.misc;

import java.util.PriorityQueue;

public class MeetingRoomsII {

    public class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {

        PriorityQueue<Interval> starts = new PriorityQueue<Interval>((i1, i2) -> i1.start - i2.start);
        PriorityQueue<Interval> ends = new PriorityQueue<Interval>((i1, i2) -> i1.end - i2.end);

        for (int i = 0; i < intervals.length; i++)
            starts.add(intervals[i]);

        int count = 0;
        while (!starts.isEmpty()) {

            Interval curr = starts.poll();

            while (ends.size() != 0 && ends.peek().end <= curr.start)
                ends.poll();

            ends.add(curr);

            count = Math.max(count, ends.size());
        }

        return count;
    }
}
