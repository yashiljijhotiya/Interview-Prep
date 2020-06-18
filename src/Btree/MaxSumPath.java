package Btree;

public class MaxSumPath {

    private static int maxSumPath;
    private static int maxSumPath(BNode root){
        if(root == null){
            return 0;
        }
        maxSumPath = Integer.MIN_VALUE;
        return findMaxPathSum(root);
    }

    private static int findMaxPathSum(BNode root){
        if(root == null ){
            return 0;
        }
        int left = findMaxPathSum(root.left);
        int right = findMaxPathSum(root.right);

        int maxSumLeft = Math.max(left,0);
        int maxSumRight = Math.max(right,0);

        int localMaxSum = maxSumLeft + maxSumRight + root.data;
        maxSumPath = Math.max(maxSumPath,localMaxSum);

        return Math.max(maxSumLeft, maxSumRight) + root.data;

    }

    public static void main(String[] args) {
        BNode root = new BNode(-1);
        root.left = new BNode(1);
        root.left.left = new BNode(4);
        root.left.left.left = new BNode(8);
        root.left.left.right = new BNode(4);
        root.left.right = new BNode(5);
        root.left.right.right = new BNode(-10);
        root.right = new BNode(2);
        System.out.println(maxSumPath(root));
    }
}
