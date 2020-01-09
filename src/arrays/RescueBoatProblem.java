package arrays;

import java.util.Arrays;

//Leetcode : Min Boats to save people
public class RescueBoatProblem {

    private static  int minBoatToRescuePeople(int people[], int weightLim){
        Arrays.sort(people);
        int totalBoats = 0;
        int l = 0;
        int r = people.length -1;
        while (l <= r){
            if(people[l] + people[r] <= weightLim){
                l++;
                r--;
            }
            else{
                r--;
            }
            totalBoats++;
        }
        return totalBoats;
     }
    public static void main(String[] args) {
        int people[] = {1,3,2,3};
        int weightLim = 3;
        System.out.println("min no. of boats required to save all people are :" + minBoatToRescuePeople(people, weightLim));
    }
}
