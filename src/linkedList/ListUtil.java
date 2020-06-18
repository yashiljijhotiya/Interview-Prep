package linkedList;

public class ListUtil {

    //insert at head
    public static SLLNode insert(int data, SLLNode head){
        SLLNode node  = new SLLNode(data);
        if(head == null){
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    //print list
    public static void printList(SLLNode head){
        if(head == null){
            return;
        }
        SLLNode temp = head;
        while(temp != null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
    }

    //reverse list
    public static SLLNode reverse(SLLNode head){
        if(head == null || head.next == null){
            return head;
        }
        SLLNode cur = head, prev = null, next = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }

    //get kth node in list
    public static SLLNode getKNode(int k, SLLNode head){
        if(head == null || k < 0){
            return null;
        }
        int c = 1;
        SLLNode temp = head;
        while(c < k && temp != null){
            temp = temp.next;
            c++;
        }
        return temp;
    }

    // get mid node
    public static SLLNode getMid(SLLNode head){
        if(head == null || head.next == null){
            return head;
        }
        SLLNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //delete kth node
    public static SLLNode deleteKNode(SLLNode head, int k){
        if(head == null || k < 0){
            return head;
        }
        SLLNode temp = head, prev = null;
        int c = 1;
        while(c < k && temp != null){
            prev = temp;
            temp = temp.next;
            c++;
        }
        if(c+1 == k && prev != null && temp != null){
            prev.next = temp.next;
        }
        return head;
    }

    public static int getSize(SLLNode head){
        if(head == null){
            return 0;
        }
        int size = 0;
        while (head != null){
            head = head.next;
            size++;
        }
        return size;
    }



}
