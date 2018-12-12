package leetcode.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Runtime: 17 ms, faster than 65.62% of Java online submissions for Merge Intervals.
 */
public class MergeOverlappingIntervals {

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

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() <= 1)
            return intervals;

        // sort the intervals
        intervals.sort(new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        ArrayList<Interval> result = new ArrayList();
        Stack<Interval> stack = new Stack();

        for (int i = 0; i < intervals.size(); i++) {
            stack.push(intervals.get(intervals.size() - 1 - i));
        }

        while (stack.size() > 1) {

            Interval i1 = stack.pop();
            Interval i2 = stack.pop();

            if (doOverlap(i1, i2)) {
                stack.push(new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end)));
            } else {
                result.add(i1);
                stack.push(i2);
            }
        }

        result.add(stack.pop());

        return result;
    }

    boolean doOverlap(Interval i1, Interval i2) {
        if (i2.start > i1.end)
            return false;
        return true;
    }
}
