package linkedList;

public class FlattenLL {

    private static  MultiNode<Integer> flattenList(MultiNode<Integer> head){
       if(head == null || head.right == null || head.down == null){
           return head;
       }
       MultiNode<Integer> temp = mergeList(head, flattenList(head.right));
       head.right = null;
       return temp;
    }

    private static  MultiNode<Integer> mergeList(MultiNode<Integer> l1, MultiNode<Integer> l2){
       if(l1 == null){
           return l2;
       }
       if(l2 == null){
           return l1;
       }
       MultiNode<Integer> dummy;
       if(l1.data < l2.data){
           dummy = l1;
           dummy.down = mergeList(l1.down,l2);

       }
       else{
           dummy = l2;
           dummy.down = mergeList(l1, l2.down);
       }
       return dummy;
    }

    private static  void printList(MultiNode<Integer> list){
        while(list != null){
            System.out.print(list.data + "->");
            list = list.down;
        }
    }

    public static void main(String[] args) {
//     MultiNode<Integer> head = new MultiNode<>(5);
//     head.right = new MultiNode<>(10);
//     head.right.right = new MultiNode<>(19);
//     head.right.right.right = new MultiNode<>(28);
//     head.down = new MultiNode<>(7);
//     head.down.down = new MultiNode<>(8);
//     head.down.down.down = new MultiNode<>(30);
//     head.right.down = new MultiNode<>(20);
//     head.right.right.down = new MultiNode<>(22);
//     head.right.right.down.down = new MultiNode<>(50);
//     head.right.right.right.down = new MultiNode<>(35);
//     head.right.right.right.down.down = new MultiNode<>(40);
//     head.right.right.right.down.down.down = new MultiNode<>(45);
//     MultiNode<Integer> result = flattenList(head);
       MultiNode<Integer> head = new MultiNode<>(1);
       head.right = new MultiNode<>(5);
       head.right.right = new MultiNode<>(7);
       head.down = new MultiNode<>(3);
       head.right.down = new MultiNode<>(11);
       head.right.right.down = new MultiNode<>(9);
       head.right.right.down.down = new MultiNode<>(20);
       MultiNode<Integer> result = flattenList(head);
       System.out.println("flatten sorted list");
       printList(result);
    }
}
