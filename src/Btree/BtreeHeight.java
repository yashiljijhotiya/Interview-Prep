package Btree;

public class BtreeHeight {

    public int hieghtOfTree(BNode root){
        if(root == null){
            return 0;
        }
        return (1+ Math.max(hieghtOfTree(root.left),(hieghtOfTree(root.right))));
    }


    public static void main (String args[]){

    }
}
