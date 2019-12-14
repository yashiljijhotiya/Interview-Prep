package dp;
import java.util.*;
// This problem is based on activity selection problem from greedy but it has one more field profit so we need to maximize the  profit by selecting activity
public class JobSelection {

    public void sortJobList( Job arr[]){
       // Arrays.sort(arr, (a, b) -> a.endTime.compareTo(b.endTime));
    }

    public void print(Job arr[]){
        for(var i : arr){
            System.out.println(i.endTime + " " + i.startTime + " " + i.profit);
        }
    }



    public static void main (String args[]){
        JobSelection j = new JobSelection();
        Job arr [] = {
                      new Job(1, 5, 26),
                      new Job(7,9, 80),
                      new Job(3, 5, 10),
                      new Job(5,10,20)

        };
        j.sortJobList(arr);
        //j.print(arr);
        Arrays.asList(arr).forEach(System.out::println);

    }

}
