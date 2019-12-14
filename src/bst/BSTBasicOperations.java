package bst;

import java.util.LinkedList;
import java.util.Queue;

public class BSTBasicOperations {

    private static BstNode root = null;

    private void insert(int data){
        root =  insertRec(root,data);
    }

    private BstNode insertRec(BstNode root, int data){
       BstNode node = new BstNode(data);
        if(root == null){
            root = node;
            return root;
        }
        if(root.data < data){
            root.right = insertRec(root.right, data);
        }
       else if(root.data > data){
            root.left = insertRec(root.left,data);
        }
        return root;
    }

    private void lot(BstNode root){
        Queue<BstNode> q = new LinkedList<>();
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            var temp = q.poll();
            System.out.println(temp.data);
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }

        }
    }

    /*private void inorder(){
        inorderRec(root);
    }
*/
    private void inorderRec(BstNode root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }

    private int minValue(){
        if(root == null){
            return -99;
        }
        while(root.left != null){
            root = root.left;
        }

        return root.data;
    }

    private int maxValue(){
        if(root == null){
            return -99;
        }
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }





    public static void main(String[] args) {
     BSTBasicOperations tree = new BSTBasicOperations();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Level order traversal of tree is:");
        tree.lot(root);
        System.out.println("Min val in tree is:");
        System.out.println(tree.minValue());
        System.out.println("Max val in tree is: ");
        System.out.println(tree.maxValue());
    //tree.inorderRec(root);
    }
}
