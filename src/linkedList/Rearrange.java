package linkedList;

public class Rearrange {

    private static SLLNode head = null;

    private static SLLNode rearrange(SLLNode head){
        if(head == null){
            return null;
        }
        SLLNode dummyNode = new SLLNode(-99);
        SLLNode curr = dummyNode;
        SLLNode head1 = head;
        SLLNode mid = findMid(head);
        SLLNode head2 = mid.next;
        mid.next = null;
        while(head1 != null || head2 != null){

            if(head1 != null){
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            }

            if(head2 != null){
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }
        return dummyNode.next;
    }

    private static SLLNode insert(int data){
        SLLNode node  = new SLLNode(data);
        if(head == null){
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }
    private static void print(SLLNode head){
        SLLNode temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }

    private static SLLNode findMid(SLLNode head){
        if(head == null || head.next == null){
            return head;
        }
        SLLNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    private static SLLNode reverse(SLLNode head){
        SLLNode cur = head, prev = null, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return prev;
    }
    public static void main(String[] args) {
        //insert(6);
        insert(5);
        insert(4);
        insert(3);
        insert(2);
        insert(1);
        //print(head);
//        System.out.println();
//        System.out.print("mid node : "+findMid(head).data);
//        reverse(head);
//        print();
        SLLNode node = rearrange(head);
        System.out.println("test");
        print(node);

    }
}
