package Btree;

import java.util.Stack;

public class SpiralOrderTraversal {

    private static void printSpiralOrder(BNode root){
        Stack<BNode> s1 = new Stack<>();
        Stack<BNode> s2 = new Stack<>();
        if(root == null)
            return;
        else{
            s1.push(root);
            while (!s1.isEmpty() || !s2.isEmpty()){
               while (!s1.isEmpty()){
                   BNode node = s1.pop();
                   System.out.println(node.data);
                   if(node.left != null){
                       s2.push(node.left);
                   }
                   if(node.right != null){
                       s2.push(node.right);
                   }
               }
               while (!s2.isEmpty()){
                   BNode node = s2.pop();
                   System.out.println(node.data);
                   if(node.right != null){
                       s1.push(node.right);
                   }
                   if(node.left != null){
                       s1.push(node.left);
                   }
               }
            }

        }
    }
    public static void main(String[] args) {

        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
        root.right.left = new BNode(7);
        root.right.left = new BNode(8);
        printSpiralOrder(root);
    }
}
