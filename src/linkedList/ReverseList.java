package linkedList;

public class ReverseList {
    SLLNode head = null;


    private SLLNode insertNode(int data){
        SLLNode newNOde  = new SLLNode(data);
        if(head == null){
            head = newNOde;
            return head;
        }
        newNOde.next = head;
        head = newNOde;

        return head;

    }

    private void print(){
        SLLNode temp = head;
        if(temp == null)
            return;
        while(temp != null) {
            System.out.println("-> " + temp.data);
            temp = temp.next;
        }
    }

    private SLLNode reverseList(){
        if(head == null || head.next == null){
            return  head;
        }
        SLLNode curr = head;
        SLLNode prev = null;
        SLLNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        rl.insertNode(1);
        rl.insertNode(2);
        rl.insertNode(3);
        rl.insertNode(4);
        rl.insertNode(5);
        rl.print();
        System.out.println("list after reverse");
        rl.reverseList();
        rl.print();
    }


}
