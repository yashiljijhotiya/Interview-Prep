package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    static int sum = 0;
    static int max_level = Integer.MIN_VALUE;

    private static int minDepth(BNode root){
        return BtreeUtil.minHeightOfTree(root);
    }


    private static int minDepthLOT(BNode root){
        int minDepth = 0;
        if(root == null){
            return minDepth;
        }
        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            minDepth++;
            while (size > 0){
                BNode temp = queue.poll();
                if(temp.left == null && temp.right == null){
                    return minDepth;
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                size--;
            }
        }
        return minDepth;
    }

    private static  int  hieghtOfTree(BNode root){
        if(root == null){
            return 0;
        }
        return Math.max(hieghtOfTree(root.left), hieghtOfTree(root.right)) +1;

    }

    private static void sumOfNodeAtMaxLevel(BNode root, int level){
        if(root == null)
            return ;
        if(level > max_level){
            sum = root.data;
            max_level = level;
        }
        else if(level == max_level){
            sum = sum + root.data;
        }
        sumOfNodeAtMaxLevel(root.left, level++);
        sumOfNodeAtMaxLevel(root.right, level++);

    }

    public static void main(String[] args) {
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
//        System.out.println("min depth of tree is : " +minDepth(root));
//        System.out.println("height of binary tree is :" + hieghtOfTree(root));
//        sumOfNodeAtMaxLevel(root, 0);
//        System.out.println("sum at max level" + sum);
        System.out.println(minDepthLOT(root));
    }
}
