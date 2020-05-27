package Btree;

public class BtreeHeight {

    private static int heightOfTree(BNode root){
        if(root == null){
            return 0;
        }
        else {
            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);

            return Math.max(lh,rh)+1;
        }
    }

    private static int minDepth(BNode root){
        return BtreeUtil.minHeightOfTree(root);
    }

    public static void main (String args[]){
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.left.left = new BNode(4);
       // root.left.left = new BNode(5);
        root.right = new BNode(6);
//        root.left.right.left = new BNode(22);
//        root.right = new BNode(3);
//        root.right.right = new BNode(6);
//        root.right.right.left = new BNode(11);
//        root.right.right.left.right = new BNode(19);
//        root.right.right.left.right.left = new BNode(33);
        System.out.println("height of binary tree is : " + heightOfTree(root));
        //System.out.println("min depth of btree is : " + minDepth(root));

    }
}
