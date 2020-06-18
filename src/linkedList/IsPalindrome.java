package linkedList;

public class IsPalindrome {
    private static SLLNode head = null;

    private static boolean isPalindromeRec(SLLNode root){
        if(root == null){
            return true;
        }
        SLLNode left = head;

        boolean isPalindrome = isPalindrome(root.next);

        if(isPalindrome == false){
            return false;
        }
        boolean ispal = (left.data == root.data);
        left = left.next;
        return ispal;
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

    public static void main(String[] args) {
        head = ListUtil.insert(1,head);
        head = ListUtil.insert(2,head);
        head = ListUtil.insert(2,head);
        head = ListUtil.insert(1,head);
        System.out.println(isPalindrome(head));

    }
}
