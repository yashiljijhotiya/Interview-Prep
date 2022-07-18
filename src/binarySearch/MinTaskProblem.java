package binarySearch;

import java.util.Arrays;

//T C : O (N*Log(N))
public class MinTaskProblem {

    private static int minWorkPerDayToCompleteTask(int task[], int days) {
        int low = 1; //i.e. min amount of work done in any day
        int high = Arrays.stream(task).max().getAsInt();
        int result = 0;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isAbleToCompleteTask(task, mid, days)) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isAbleToCompleteTask(int task[], int wpd, int days) {
        int curDay = 0;
        for (int t : task) {
            double dayReq = (Math.ceil((double) t / (double) wpd));
            curDay += dayReq;
            if (curDay > days) {
                return false;
            }
        }
        return curDay < days;
    }

    public static void main(String[] args) {
        int task[] = {3, 4, 7, 15};
        int days = 10;
        System.out.println("Min work per day  require to finish all the task are : " + minWorkPerDayToCompleteTask(task, days));

    }
}
