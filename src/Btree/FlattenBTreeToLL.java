package Btree;
//Leetcode 114
public class FlattenBTreeToLL {

    private static void flatten(BNode root){
        if(root == null){
            return;
        }
    }

    private static BNode flattenTree(BNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }

        BNode leftTail = flattenTree(root.left);
        BNode rightTail = flattenTree(root.right);

        if(leftTail != null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail  == null ? leftTail : rightTail;
    }
}
