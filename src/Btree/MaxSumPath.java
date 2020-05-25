package Btree;

public class MaxSumPath {

    private static int maxSumPath(BNode root){
        if(root == null){
            return 0;
        }
        int result = Integer.MIN_VALUE;
        return findMaxPathSum(root, result);
    }

    private static int findMaxPathSum(BNode root, int result){
        if(root == null ){
            return 0;
        }
        int left = findMaxPathSum(root.left, result);
        int right = findMaxPathSum(root.right, result);
        int maxStraight = Math.max(Math.max(left, right) + root.data, root.data);
        int maxCaseVal = Math.max(maxStraight, left+right+root.data);
        result = Math.max(maxCaseVal, result);
        return result;
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
