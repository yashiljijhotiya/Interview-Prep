package linkedList;

public class LinkedListTest {

    SLLNode head = null;

    private SLLNode insert(int data){
        SLLNode node = new SLLNode(data);
        if(head == null){
            head = node;
            return  head;
        }
        node.next = head;
        head = node;
        return  head;
    }

    private void print(){

        if(head == null)
            return;
        SLLNode temp = head;
        while(temp != null){
            System.out.println(" -->" + temp.data);
            temp = temp.next;
        }
    }

    // for reversing list
    private SLLNode reverse(SLLNode curr, SLLNode prev){
        if(curr.next == null){
            head = curr;
            curr.next = prev;
            return head;
        }
        SLLNode next1  =  curr.next;
        curr.next = prev;
        reverse(next1, curr);

      return head;
    }



    // function to remove nth node from last
    private SLLNode removeNodeFromLast(int n){
        SLLNode fast = head;
        SLLNode slow = head;
        int i = 0;
        while( i < n ){
            fast = fast.next;
            i++;
        }

        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }



    public static void main(String[] args) {
        LinkedListTest l = new LinkedListTest();

    }
}
