package sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfEveryKWindow {

    private static void maxInKSizeWindow(int arr[], int k){
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < k; i++){
            while (!dq.isEmpty() && arr[i] > dq.getLast()){
                dq.pollLast();
            }
            dq.addLast(i);
        }
    }


    public static void main(String[] args) {

    }
}
