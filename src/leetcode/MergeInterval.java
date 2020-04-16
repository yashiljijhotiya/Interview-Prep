package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeInterval {

    private static class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    private static List<Interval> mergeInterval(List<Interval> intervals){

        if(intervals == null || intervals.size() == 0){
            return null;
        }

        List<Interval> mergeIntervals = new ArrayList<>();
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;

        while (iterator.hasNext()){
            interval = iterator.next();
            if(interval.start <= end){
                end = Math.max(interval.end,end);
            }
            else {
                mergeIntervals.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergeIntervals.add(new Interval(start,end));

     return mergeIntervals;
    }
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(7,9));
        intervals.add(new Interval(2,5));
        for(Interval interval : mergeInterval(intervals)){
            System.out.print("{ " + interval.start + ", " +interval.end  +" }");
            System.out.println();
        }

    }
}
