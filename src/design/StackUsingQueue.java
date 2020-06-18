package design;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private static Queue<Integer> queue;

    public StackUsingQueue(){
        queue = new LinkedList<>();
    }

    private static void push(int val){
        int size = queue.size();
        queue.add(val);
        for (int i = 0; i < size; i++){
            queue.add(queue.remove());
        }
    }

    private static int pop(){
        if(queue.isEmpty()){
            return -1;
        }
        return queue.poll();
    }

    private static int peek(){
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }

    private static boolean isEmpty(){
        return queue.isEmpty();
    }
}
