package queue;

import linkedList.SLLNode;

public class QueueByCircularLL {
    private static SLLNode rear = null, front = null;

    private static void enqueue(int data){
        SLLNode node = new SLLNode(data);

        if(rear == null){
            rear = front = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    private static void dequeue(){
     if(front == null){
         return;
     }
     SLLNode temp = front;
     front = front.next;
     if(front == null){
         rear = null;
     }
    }

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        dequeue();
        System.out.println(front.data);
        System.out.println(rear.data);
    }
}
