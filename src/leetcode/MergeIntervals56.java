package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/12/19.
 */
public class MergeIntervals56 {

     public static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new LinkedList<>();

        if (intervals.size() <= 0) {
            return result;
        }

        int begin = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval node = intervals.get(i);
            if (node.start > end) {
                result.add(new Interval(begin, end));
                begin = node.start;
                end = node.end;
            } else {
                end = Math.max(end, node.end);
            }
        }
        result.add(new Interval(begin, end));

        return result;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);

        List<Interval> intervals = new LinkedList<>();
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i1);

        for (Interval tmp: intervals) {
            System.out.println(tmp.start);
        }

        List<Interval> result = merge(intervals);

        for (Interval tmp: result) {
            System.out.println(tmp.start);
        }

    }
}
