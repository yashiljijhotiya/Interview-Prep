package linkedList;

public class LinkedListOperation {

    SLLNode head = null;

    private SLLNode insert(int data){

        SLLNode node = new SLLNode(data);
        if(head == null){
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;

    }


    private void printList(){
        SLLNode temp = head;
        while(temp != null){
            System.out.println(" --> " + temp.data);
            temp = temp.next;
        }

    }

    private void deleteNode(int data){
        if(head == null){
            return;
        }
        SLLNode temp1 = head;
        SLLNode temp2 = head;
        if(head.data == data){
            head = head.next;
        }
        while(temp1 != null && temp1.data != data){
              if(temp1.data == data){
                  temp2 = temp1;

              }
        }
    }


    public static void main(String[] args) {
        LinkedListOperation l = new LinkedListOperation();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.printList();
    }


}
