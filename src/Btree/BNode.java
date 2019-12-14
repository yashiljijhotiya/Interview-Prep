package Btree;

public class BNode {

    int data;
    BNode left;
    BNode right;

    public BNode(int data){
        this.data = data;
        left = right = null;
    }

}
