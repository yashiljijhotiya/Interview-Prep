package linkedList;

public class IsPalindrome {
    private static SLLNode head = null;
    private static SLLNode ref = head;
    private static boolean isPalindromeRec(SLLNode root){
        if(root == null){
            return true;
        }
        boolean ans = isPalindromeRec(root.next);
        boolean isEqual = ref.data == root.data ? true : false;
        ref = ref.next;
        return ans && isEqual;
    }

    public static boolean isPalindrome(SLLNode head) {
        SLLNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        SLLNode prev = null;
        while(slow != null){
            SLLNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        slow = prev;
        fast = head;
        while(slow != null){
            if(fast.data != slow.data){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private static  int sum = 0;
    private static int findVal(SLLNode head, int n){
        if(head == null){
            return 1;
        }
        sum += 2^n * findVal(head.next, n+1);
        return sum;

    }

    public static void main(String[] args) {
        head = ListUtil.insert(1,head);
        head = ListUtil.insert(0,head);
        head = ListUtil.insert(1,head);
        //head = ListUtil.insert(1,head);
        //System.out.println(isPalindromeRec(head));
        System.out.println(findVal(head, 0));

    }
}
