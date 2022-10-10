package linkedList;

public class IsPalindrome {
    private static SLLNode head = null;
    private static SLLNode ref = head;

    private static boolean isPalindromeRec(SLLNode root) {
        if (root == null) {
            return true;
        }
        boolean ans = isPalindromeRec(root.next);
        boolean isEqual = ref.data == root.data ? true : false;
        ref = ref.next;
        return ans && isEqual;
    }

    public static boolean isPalindrome(SLLNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        SLLNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        SLLNode headSecondHalf = reverseList(slow);
        SLLNode copyHeadSecondHalf = headSecondHalf;
        SLLNode temp = head;
        while (temp != null && headSecondHalf != null) {
            if (temp.data != headSecondHalf.data) {
                break;
            }
            temp = temp.next;
            headSecondHalf = headSecondHalf.next;
        }
        reverseList(copyHeadSecondHalf);
        if (temp == null || headSecondHalf == null) {
            return true;
        }
        return false;

    }

    private static SLLNode reverseList(SLLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLLNode prev = null;
        SLLNode curr = head;
        SLLNode nxt;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head = prev;
        return head;
    }

    private static int sum = 0;

    private static int findVal(SLLNode head, int n) {
        if (head == null) {
            return 1;
        }
        sum += 2 ^ n * findVal(head.next, n + 1);
        return sum;

    }

    public static void main(String[] args) {
        head = ListUtil.insert(1, head);
        head = ListUtil.insert(0, head);
        head = ListUtil.insert(1, head);
        //head = ListUtil.insert(1,head);
        //System.out.println(isPalindromeRec(head));
        System.out.println(findVal(head, 0));

    }
}
