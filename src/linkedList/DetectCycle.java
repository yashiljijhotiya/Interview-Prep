package linkedList;

public class DetectCycle {

    private static boolean hasCycle(SLLNode head) {
        if (head == null) {
            return false;
        }
        SLLNode slow = head;
        SLLNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static int calculateLengthOfCycle(SLLNode head) {
        if (head == null) {
            return 0;
        }
        SLLNode slow = head;
        SLLNode fast = head;
        int len = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                len = findLength(slow);
                break;
            }
        }
        return len;
    }

    private static int findLength(SLLNode slow) {
        SLLNode temp = slow;
        int len = 0;
        do {
            temp = temp.next;
            len++;
        } while (temp != slow);
        return len;
    }

    private static SLLNode findStartingNode(SLLNode head, int cycleLen) {
        if (head == null) {
            return null;
        }
        SLLNode pointer1 = head, pointer2 = head;
        //move pointer2 by k dist ie len of cycle
        while (cycleLen > 0) {
            cycleLen--;
            pointer2 = pointer2.next;
        }
        //increment both pointer until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    private static SLLNode findMiddle(SLLNode head) {
        if (head == null) {
            return null;
        }
        SLLNode slow = head;
        SLLNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SLLNode head = new SLLNode(1);
        head.next = new SLLNode(2);
        head.next.next = new SLLNode(3);
        head.next.next.next = new SLLNode(4);
        head.next.next.next.next = new SLLNode(5);
        head.next.next.next.next.next = new SLLNode(6);
        head.next.next.next.next.next.next = head.next.next;
        //System.out.println(hasCycle(head));
        //  System.out.println(calculateLengthOfCycle(head));
        int len = calculateLengthOfCycle(head);
        System.out.println(findStartingNode(head, len).data);

    }
}
