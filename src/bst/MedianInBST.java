package bst;

import java.util.ArrayList;
import java.util.List;

public class MedianInBST {
    private static BstNode root = null;
    private static List<BstNode> list = new ArrayList<>();
    private static BstNode insert(int data){
        return insertRec(root, data);
    }

    private static BstNode insertRec(BstNode root, int data){
        BstNode node  = new BstNode(data);
        if(root == null){
            root = node;
            return root;
        }

        if(root.data > data){
            root.left = insertRec(root.left, data);
        }
        if(root.data < data){
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    private static void inorder(BstNode root){

        if(root != null){
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }
    }

    private static int findMedian(){
        int size = list.size();
        int median = 0;
        if(size%2 == 0){
            median = list.get(size/2).data + list.get(size+1/2).data;
        }
        else {
            median = list.get(size+1/2).data;
        }

        return median;
    }

}
