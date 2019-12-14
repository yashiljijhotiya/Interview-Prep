//Binary Tree to Binary Search Tree Conversion
package Btree;
import java.util.Iterator;
import java.util.TreeSet;


public class BTreeToBST {

 private  void inorder(BNode root, TreeSet s){

     if(root == null){
         return;
     }
         inorder(root.left, s);
         s.add(root.data);
         inorder(root.right,s);

 }

 private  void inorderTraversal(BNode root){
     if(root != null){
         inorderTraversal(root.left);
         System.out.println(root.data);
         inorderTraversal(root.right);
     }
 }

 private void convertToBST(BNode root, Iterator<Integer> it){
     if(root == null){
         return;
     }
     convertToBST(root.left,it);
     root.data = it.next();
     convertToBST(root.right,it);
 }


    public static void main(String[] args) {
        BTreeToBST t = new BTreeToBST();
        BNode root =  new BNode(8);
        root.left = new BNode(3);
        root.right = new BNode(5);
        root.left.left = new BNode(10);
        root.left.right = new BNode(2);
        root.right.left = new BNode(4);
        root.right.right = new BNode(6);
        TreeSet<Integer> s = new TreeSet<>();
        Iterator itr = s.iterator();

        t.inorder(root,s);
        t.inorderTraversal(root);

    }
}
