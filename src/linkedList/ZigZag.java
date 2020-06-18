package linkedList;

public class ZigZag {
// a < b > c < d > e < f   1->2->3->4
    private static SLLNode head = null;
    private static  SLLNode rearrangeZigZag(SLLNode head){
        if(head == null || head.next == null){
            return head;
        }
        else{
            SLLNode temp = head;
            boolean flag = true;
            while(temp.next != null){
              if(flag){
                  if(temp.data > temp.next.data){
                      int  data = temp.data;
                      temp.data = temp.next.data;
                      temp.next.data = data;
                  }
              }
              else {
                  if(temp.data < temp.next.data){
                      int  data = temp.data;
                      temp.data = temp.next.data;
                      temp.next.data = data;
                  }
              }
                flag = !flag;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        head = ListUtil.insert(4,head);
        head = ListUtil.insert(3,head);
        head = ListUtil.insert(2,head);
        head = ListUtil.insert(1,head);
        head = rearrangeZigZag(head);
        ListUtil.printList(head);
    }
}
