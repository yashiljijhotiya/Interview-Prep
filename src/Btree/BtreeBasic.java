package Btree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BtreeBasic {

    private static int heightOfTree(BNode root){
        if(root == null){
            return 0;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return 1+ Math.max(left,right);
    }

    private static int minHeightOfTree(BNode root){
        if(root == null){
            return 0;
        }
        int left = minHeightOfTree(root.left);
        int right = minHeightOfTree(root.right);
        return 1 + Math.min(left,right);
    }

    private static int sizeOfTree(BNode root){
        if(root == null){
            return 0;
        }
        int left = sizeOfTree(root.left);
        int right = sizeOfTree(root.right);
        return 1 + left + right;
    }

    private static void lot(BNode root){
        if(root == null){
            return;
        }
        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count > 0){
                BNode node = queue.poll();
                System.out.print(node.data + " ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                count--;
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
        root.right = new BNode(3);
        System.out.println("height of tree is : " +heightOfTree(root));
        System.out.println("min height of tree is : " + minHeightOfTree(root));
        System.out.println("size of tree is : " + sizeOfTree(root));
        lot(root);
    }
}
