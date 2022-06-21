package Btree;

public class MergeTree {

    private static BNode mergeTrees(BNode root1, BNode root2){
        if(root1 == null && root2 == null){
            return null;
        }
        else if(root1 == null){
            return root2;
        }
        else if(root2 == null){
            return root1;
        }
        BNode mergeNode = new BNode(root1.data + root2.data);
        mergeNode.left = mergeTrees(root1.left, root2.left);
        mergeNode.right = mergeTrees(root1.right, root2.right);
        return mergeNode;
    }
}
