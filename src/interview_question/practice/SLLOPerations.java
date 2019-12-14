package interview_question.practice;

import javax.sound.midi.Soundbank;

public class SLLOPerations {

    private static SLLNode head;

    private static SLLNode insert(int data){
        SLLNode node = new SLLNode(data);
        if(head == null){
           head = node;
        }
        else{
            node.next = head;
            head = node;
        }
        return  head;
    }

    private static void printList(){
        SLLNode temp = head;
        while(temp != null){
            System.out.println("->" + temp.data);
            temp = temp.next;
        }
    }

    private static void reverseList(){
        SLLNode prev = null;
        SLLNode curr = head;
        SLLNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    private static  SLLNode reverseListRec(SLLNode curr, SLLNode prev){
        if(curr.next == null){
            head = curr;
            curr.next = prev;
            return head;
        }
        SLLNode next = curr.next;
        curr.next = prev;
        reverseListRec(next, curr);
        return head;
    }
    public static void main(String[] args) {
      insert(1);
      insert(2);
      insert(3);
      insert(4);
      insert(5);
      printList();
      System.out.println("reverse of list");
      reverseList();
      printList();
    }
}
