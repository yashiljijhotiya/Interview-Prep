package problem_solving;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MeetingRoom {

    private static class Interval{
        int start_time;
        int end_time;
        public Interval(int start_time, int end_time){
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }

    private static int minNoMeetingRoom(ArrayList<Interval> intervals){
        if(intervals == null || intervals.size() == 0)
            return 0;

        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end_time - b.end_time);
        intervals.sort((Interval i1 , Interval i2) -> i1.start_time - i2.start_time);
        pq.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
               Interval current = intervals.get(i);
               Interval earliest = pq.remove();
               if(current.start_time >= earliest.end_time){
                   earliest.end_time = current.end_time;
               }
               else {
                   pq.add(current);
               }
               pq.add(earliest);

        }
        return pq.size();
    }


    public static void main(String[] args) {
        ArrayList<Interval> tmintv = new ArrayList<>();
        tmintv.add(new Interval(2,15));
        tmintv.add(new Interval(7,11));
        tmintv.add(new Interval(1,4));
        tmintv.add(new Interval(22,24));
        tmintv.add(new Interval(11,19));
        System.out.println("min no. of meeting room required : " + minNoMeetingRoom(tmintv));
    }
}
