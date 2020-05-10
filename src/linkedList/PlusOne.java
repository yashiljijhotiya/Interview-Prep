package linkedList;

public class PlusOne {

    private static SLLNode head = null;

    private static SLLNode insert(int data){
        SLLNode node  = new SLLNode(data);
        if(head == null){
            head = node;
            return head;
        }
        node.next = head;
        head = node;

        return head;
    }
    private static void printList(){
        SLLNode temp = head;
        while (temp != null){
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }
    }

    private static  SLLNode  addPlusOne(){
    SLLNode sentinel  = new SLLNode(0);
    sentinel.next = head;
    SLLNode notNine = sentinel;
    SLLNode temp = head;
    while(temp != null){
        if(temp.data != 9){
            notNine = temp;
        }
        temp = temp.next;
    }
    // 1->4->9->4

    notNine.data++;
    notNine = notNine.next;

    while (notNine != null){
        notNine.data = 0;
        notNine = notNine.next;
    }
    return sentinel.data != 0 ? sentinel : sentinel.next;
    }

    public static void main(String[] args) {
        insert(9);
        insert(9);
        insert(9);
        insert(9);
        printList();
    }
}
