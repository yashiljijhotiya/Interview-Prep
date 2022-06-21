package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        int distanceFromOrigin(){
            return (x*x)+(y*y);
        }

    }


    private static List<Point> findKClosestPoint(Point [] points, int k){
        if(points == null || points.length == 0 || k > points.length || k == 0){
            return new ArrayList<>();
        }
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p2.distanceFromOrigin() - p1.distanceFromOrigin());

        for(Point p : points){
            pq.add(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return new ArrayList<>(pq);
    }


    public static void main(String[] args) {
        Point[]points = new Point[]{new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = findKClosestPoint(points,2);
        for(Point p : result){
            System.out.println("{"+ p.x + ", "+ p.y + " }");
        }

    }
}
