package Btree;

public class BtreeToDll {

    private static BNode head = null;
    private static BNode prev = null;

    private static void btreeToDll(BNode root){
        if(root == null){
            return;
        }
        btreeToDll(root.left);
        if(prev == null){
          head = root;
        }
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        btreeToDll(root.right);
    }

    private static void printList(){
        BNode temp = head;
        while (temp != null){
            System.out.print(" < = > "+ temp.data);
            temp = temp.right;

        }
    }


    public static void main(String[] args) {
        BNode root = new BNode(10);
        root.left = new BNode(12);
        root.right = new BNode(15);
        root.left.left = new BNode(25);
        root.left.right = new BNode(30);
        root.right.left = new BNode(36);
        btreeToDll(root);
        printList();
    }
}
