package Btree;

import java.util.ArrayList;
import java.util.HashSet;

public class PrintNodeKDistLeaf {

    private static void printKDistNodeFromLeaf(BNode root, int k){
        if(root == null || k < 0){
            return;
        }
        HashSet<BNode> set = new HashSet<>();
        ArrayList<BNode> list = new ArrayList<>();
        printNode(root,k,set,list);
        for(BNode node : set){
            System.out.println(node.data);
        }
    }

    private static void printNode(BNode root, int k, HashSet<BNode> set, ArrayList<BNode> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && list.size() >= k){
            set.add(list.get(list.size() - k));
            return;
        }
        list.add(root);
        printNode(root.left,k,set,list);
        printNode(root.right,k,set,list);
        list.remove(root);
    }
    public static void main(String[] args) {
        BNode root = new BNode(15);
        root.left = new BNode(10);
        root.right = new BNode(20);
        root.left.left = new BNode(8);
        root.left.right = new BNode(12);
        root.right.left = new BNode(16);
        root.right.right = new BNode(25);
        root.right.left.left = new BNode(18);
        printKDistNodeFromLeaf(root,1);

    }
}
