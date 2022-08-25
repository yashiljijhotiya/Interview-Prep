package bst;

public class BSTPractice {

    private static int findInorderSuccessor(int val, BstNode root) {
        if (root == null) {
            return 0;
        }
        BstNode successor = null;
        while (root != null) {
            if (root.data <= val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor == null ? 0 : successor.data;
    }

    //Leetcode: 938
    private static int rangeSum(BstNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.data >= low && root.data <= high) {
            return root.data + rangeSum(root.left, low, high) + rangeSum(root.right, low, high);
        } else if (root.data < low) {
            return rangeSum(root.right, low, high);
        } else {
            return rangeSum(root.left, low, high);
        }

    }

    public static void main(String[] args) {
        BstNode root = new BstNode(20);
        root.left = new BstNode(8);
        root.right = new BstNode(22);
        root.left.left = new BstNode(4);
        root.left.right = new BstNode(12);
        root.left.right.left = new BstNode(10);
        root.left.right.right = new BstNode(14);
        System.out.println(findInorderSuccessor(8, root));
        System.out.println(rangeSum(root, 4, 14));

    }
}
