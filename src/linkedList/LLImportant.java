package linkedList;

public class LLImportant {

    private static void printKthFromLast(SLLNode head, int k){
        if(head == null && k < 1){
            return;
        }
        int c = 0;
        SLLNode main = head , reference = head;
        while(c < k){
            if(reference == null){
                System.out.println(k + "is greater than no. of nodes in the list");
                return;
            }
            reference = reference.next;
            c++;
        }

        while(reference != null){
            reference = reference.next;
            main = main.next;
        }
        System.out.println(k+"th node from last in list is :" +main.data);
    }

    private static void printNthNode(SLLNode head, int n){
        if(head == null){
            return;
        }

        int c =0;
        SLLNode temp = head;
        while(c < n){
            if( temp == null){
                System.out.println("n is greater than list size");
                return;
            }
            temp = temp.next;
        }
        System.out.println(n+"th node in list is :"+temp.data);
    }

    private static boolean findLoop(SLLNode head){
        if(head == null){
            return false;
        }
        SLLNode fast = head;
        SLLNode slow = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    private  static  SLLNode addTwoList(SLLNode l1, SLLNode l2){
        SLLNode dummy = new SLLNode(0);
        SLLNode result = dummy;
        int carry = 0;
        while (l1 != null && l2 != null){
            int val1 = l1 != null ? l1.data : 0;
            int val2 = l2 != null ? l2.data : 0;
            int sum = val1 + val2 + carry;
            carry = sum/10;
            int last_digit = sum%10;
            SLLNode newNode = new SLLNode(last_digit);
            result.next = newNode;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            result = result.next;
        }
        if(carry > 0){
            SLLNode node = new SLLNode(carry);
            result.next = node;
            result = result.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
