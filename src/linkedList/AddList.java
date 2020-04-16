package linkedList;

public class AddList {

    private static SLLNode addList(SLLNode node1, SLLNode node2){
         node1 = ListUtil.reverse(node1);
         node2 = ListUtil.reverse(node2);
         ListUtil.printList(node1);
         ListUtil.printList(node2);
         return node1;
    }

    public static void main(String[] args) {
        SLLNode node1 = ListUtil.insert(5,null);
        node1 = ListUtil.insert(4,node1);
        node1 = ListUtil.insert(3, node1);
        node1 = ListUtil.insert(2, node1);
        node1 = ListUtil.insert(1, node1);


    }


}
