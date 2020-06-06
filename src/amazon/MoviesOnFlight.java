package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoviesOnFlight {

    private static List<Integer> findMovies(int movieDurations [], int d){
        List<Integer> movieToWatch = new ArrayList<>();

         if(movieDurations == null || movieDurations.length == 0){
            return movieToWatch;
         }
        Arrays.sort(movieDurations);
        d = d - 30;
        int l  = 0, r = movieDurations.length - 1, max = Integer.MIN_VALUE;
        while (l < r){
            if(movieDurations[l] + movieDurations[r] > d){
                r--;
            }
            else{
                if(movieDurations[l] + movieDurations[r] > max){
                    max = movieDurations[l] + movieDurations[r];
                    movieToWatch.add(0,movieDurations[l]);
                    movieToWatch.add(1, movieDurations[r]);
                }
                l++;
            }
        }

        return movieToWatch;
    }
    public static void main(String[] args) {
        int [] movieDurations = {90, 85, 75, 60, 120, 150, 125};
        System.out.println(findMovies(movieDurations, 250));
    }
}
