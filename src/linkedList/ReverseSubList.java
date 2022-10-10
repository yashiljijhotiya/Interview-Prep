package linkedList;

public class ReverseSubList {

    //Here p & q are the positions in the linked list
    private static SLLNode reverseSubList(int p, int q, SLLNode head) {
        if (p == q) {
            return head;
        }
        SLLNode curr = head, prev = null;
        for (int i = 0; curr != null && i < p - 1; i++) {
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
