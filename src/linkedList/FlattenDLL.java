package linkedList;

public class FlattenDLL {

    private static class DLL{
        int data;
        DLL next;
        DLL prev;
        DLL child;

        DLL(int data){
            this.data = data;
            next = prev = child = null;
        }
    }

    private static DLL flatten(DLL head){
        if(head == null || (head.next == null && head.child == null)){
            return head;
        }
        DLL child = head.child;
        if(head.child != null){
            DLL curr = child;
            while (curr.next != null){
                curr = curr.next;
            }
            child.prev = head;
            curr.next = head.next;
            head.next = child;
            if(curr.next != null){
                curr.next.prev = curr;
            }
            head.child = null;
        }
        flatten(head.next);
        return head;
    }

    public static void main(String[] args) {
    }
}
