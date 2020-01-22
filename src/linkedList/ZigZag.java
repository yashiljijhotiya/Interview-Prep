package linkedList;

public class ZigZag {

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
                  flag = !flag;
              }
              else {
                  if(temp.data < temp.next.data){
                      int  data = temp.data;
                      temp.data = temp.next.data;
                      temp.next.data = data;
                  }
                  flag = !flag;
              }
              temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
