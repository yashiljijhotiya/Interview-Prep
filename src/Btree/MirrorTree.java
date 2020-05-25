package Btree;
/*
Leetcode: is symmetric [1,2,2,3,4,4,3]
    1
   / \
  2   2
 / \ / \
3  4 4  3
* **/
public class MirrorTree {

    private static BNode mirrorOfBTree(BNode root){
        if(root == null){
            return null;
        }
        else {
            mirrorOfBTree(root.left);
            mirrorOfBTree(root.right);
            BNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    private static boolean isSymmetric(BNode root){
        if(root == null){
            return true;
        }
        return isSymmetricUtil(root.left, root.right);
    }

    private static boolean isSymmetricUtil(BNode root1, BNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1.data != root2.data){
            return false;
        }
        return isSymmetricUtil(root1.left, root1.right) && isSymmetricUtil(root2.left, root2.right);
    }
}
