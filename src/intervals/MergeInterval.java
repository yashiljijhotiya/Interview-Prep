package intervals;

import java.util.*;
//TC: n*log(n)
public class MergeInterval {

    private static class Interval{
        private int startTime;
        private int endTime;

        @Override
        public String toString() {
            return "Interval{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        Interval(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;

        }
    }

    private static List<Interval> mergeInterval(List<Interval> intervals){
        List<Interval> mergeIntervals = new ArrayList<>();
        Comparator<Interval> intervalComparator = (o1, o2) -> {
            return o1.startTime - o2.startTime;
        };
        Collections.sort(intervals, intervalComparator);
        System.out.println(intervals.toString());
        Iterator<Interval> iterator = intervals.iterator();
        int startTime = iterator.next().startTime;
        int endTime = iterator.next().endTime;

        while (iterator.hasNext()){
            Interval interval = iterator.next();
            if(interval.startTime < endTime){
                endTime = Math.max(interval.endTime, endTime);
            }else {
                mergeIntervals.add(new Interval(startTime, endTime));
                startTime = interval.startTime;
                endTime = interval.endTime;
            }
        }
        mergeIntervals.add(new Interval(startTime, endTime));

        return mergeIntervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,9));
        System.out.println(mergeInterval(intervals).toString());
    }
}
