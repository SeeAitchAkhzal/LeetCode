package leetcode.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 7 ms, faster than 84.30% of Java online submissions for Insert Interval.
 */
public class InsertInterval {

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

    boolean intersect(Interval i1, Interval i2) {
        boolean yes = false;
        if ((i1.start >= i2.start && i1.start <= i2.end) ||
            i2.start >= i1.start && i2.start <= i1.end) {
            yes = true;
        }

        if ((i1.start >= i2.start && i1.end <= i2.end) ||
            (i2.start >= i1.start && i2.end <= i1.end)) {
            yes = true;
        }

        return yes;
    }

    int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList();
        Interval prev = null;
        boolean added = false;

        for (Interval intv : intervals) {

            if (prev != null) {
                if (intersect(prev, intv)) {
                    Interval mergedIntv = new Interval(Math.min(intv.start, prev.start), Math.max(intv.end, prev.end));
                    result.remove(result.size() - 1);
                    result.add(mergedIntv);
                    prev = mergedIntv;
                } else {
                    prev = intv;
                    result.add(intv);
                }
            } else if (intersect(intv, newInterval)) {
                // check if intersects with new interval
                Interval mergedIntv = new Interval(
                        Math.min(intv.start, newInterval.start),
                        Math.max(intv.end, newInterval.end));
                result.add(mergedIntv);
                prev = mergedIntv;
                added = true;
            } else {

                if (compare(newInterval, intv) < 0) {
                    if (!added) {
                        result.add(newInterval);
                        result.add(intv);

                        added = true;
                    } else {
                        result.add(intv);
                    }
                } else {
                    result.add(intv);
                }
            }
        }

        if (!added) {
            result.add(newInterval);
        }

        return result;
    }

}
