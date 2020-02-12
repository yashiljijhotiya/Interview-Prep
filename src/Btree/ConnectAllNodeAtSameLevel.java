package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllNodeAtSameLevel {

    static ConnectNode root;

    private static class ConnectNode{
        int data;
        ConnectNode left;
        ConnectNode right;
        ConnectNode next;

        public ConnectNode(int data){
            this.data = data;
            left = right = next = null;
        }
    }

    private static  void connectNode(ConnectNode root){
        if(root == null)
            return;
        Queue<ConnectNode> q = new LinkedList<>();
        ConnectNode prev;
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            prev = null;
            while(count > 0){
                ConnectNode temp = q.poll();
                if(prev != null){
                    prev.next = temp;
                }
                prev = temp;
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
                count--;
            }
        }
    }

    public static void main(String[] args) {
        ConnectAllNodeAtSameLevel b = new ConnectAllNodeAtSameLevel();
        b.root = new ConnectNode(3);
        b.root.left = new ConnectNode(2);
        b.root.right = new ConnectNode(5);
        b.root.left.left = new ConnectNode(7);
        b.root.left.right = new ConnectNode(4);
        b.root.right.left = new ConnectNode(6);
        b.root.right.right = new ConnectNode(7);
        connectNode(root);

    }
}
