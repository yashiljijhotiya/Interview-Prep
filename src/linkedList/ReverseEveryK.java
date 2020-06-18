package linkedList;

public class ReverseEveryK {

    private static SLLNode reverseEveryK(SLLNode head, int k){
        if(head == null){
            return  head;
        }
        SLLNode current = head, prev = null, next = null;
        int count = 0;
        while(count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next != null){
            head.next = reverseEveryK(next,k);
        }
        return prev;
    }
    public static void main(String[] args) {
        SLLNode head = null;
        head = ListUtil.insert(1, head);
        head = ListUtil.insert(2, head);
        head = ListUtil.insert(3, head);
        head = ListUtil.insert(4, head);
        head = ListUtil.insert(5, head);
        head = ListUtil.insert(6, head);
        head = ListUtil.insert(7, head);
        ListUtil.printList(head);
        head = reverseEveryK(head,3);
        System.out.println();
        ListUtil.printList(head);

    }
}
