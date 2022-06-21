package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode {

    static BNode root;
    static int sum = 0;


    /** Leetcode 993 */
    private static boolean isCousins(BNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<BNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundX = false;
        boolean foundY = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            foundX = false;
            foundY = false;
            for (int i = 0; i < size; i++) {
                BNode curr = queue.poll();
                if (curr.data == x)
                    foundX = true;
                if (curr.data == y)
                    foundY = true;
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.data == x && curr.right.data == y) || (curr.left.data == y && curr.right.data == x)) {
                        return false;
                    }
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer((curr.right));
                }
            }
            if (foundX && foundY) {
                return true;
            }
        }
        return false;
    }

    private static int leftLeafSum(BNode root){
        return leftLeafSumRec(root, false);
    }

    private static int leftLeafSumRec(BNode root,  boolean isLeft){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null && isLeft){
            return root.data;
        }
        return leftLeafSumRec(root.left, true) + leftLeafSumRec(root.right, false);
    }




    public static void main(String[] args) {
        BtreeOperation b = new BtreeOperation();
        b.root = new BNode(9);
        b.root.left = new BNode(8);
        b.root.right = new BNode(6);
        b.root.left.left = new BNode(5);
        b.root.left.right = new BNode(2);
        b.root.right.left = new BNode(1);
        System.out.println(leftLeafSum(b.root));
    }

}
