package linkedList;

public class FlattenLL {

    private static  MultiNode<Integer> flattenList(MultiNode<Integer> list){
        MultiNode<Integer> temp = list;
        MultiNode<Integer> result = null;
        while(temp != null){
            result = mergeList(temp, result);
            temp = temp.right;
        }
        return result;

    }

    private static  MultiNode<Integer> mergeList(MultiNode<Integer> l1, MultiNode<Integer> l2){
        MultiNode<Integer> head = new MultiNode<>();
        MultiNode<Integer> temp = head;
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                temp.down = l1;
                temp = temp.down;
                l1 = l1.down;
            }
            else{
                temp.down = l2;
                temp = temp.down;
                l2 = l2.down;
            }
        }
       temp.down = (l1 == null) ? l2 : l1;
        return head.down;
    }

    private static  void printList(MultiNode<Integer> list){
        while(list != null){
            System.out.println(list.data + "->");
            list = list.down;
        }
    }

    public static void main(String[] args) {
     MultiNode<Integer> head = new MultiNode<>(5);
     head.right = new MultiNode<>(7);
     head.down = new MultiNode<>(11);
     head.down = new MultiNode<>(17);
     head.right.down = new MultiNode<>(12);
     head.right.down = new MultiNode<>(15);
     head.right.right = new MultiNode<>(21);
     head.right.right = new MultiNode<>(99);
     head.right.right.down = new MultiNode<>(117);
     MultiNode<Integer> result = flattenList(head);
     System.out.println("flatten sorted list");
     printList(result);
    }
}
