package linkedList.dll;

public class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int data) {
        this.data = data;
        next = prev = null;
    }
}
