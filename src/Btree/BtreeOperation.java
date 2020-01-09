package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class BtreeOperation {

    static BNode root;
    Queue<BNode> q = new LinkedList<BNode>();
    public void lot(){
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            BNode temp = q.poll();
            System.out.println(" "+ temp.data);
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
    }

    private static boolean  isBst(BNode root, Integer min, Integer max){
        if(root == null)
        {
            return true;
        }
        if(root.data <= min || root.data > max){
            return false;
        }
        return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
    }

    private static void lotNew(BNode root){
        if(root == null)
            return;
        else{
            Queue<BNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int count = q.size();
                while (count > 0){
                    BNode temp = q.poll();
                    System.out.print(temp.data + ",");
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                    count--;
                }
                System.out.println();
            }
        }
    }

    private static void leftView(BNode root){
        if(root == null)
            return;
        else{
            Queue<BNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int count = q.size();
                int qCount = q.size();
                while(count > 0){
                    BNode temp = q.poll();
                    if(count == qCount){
                        System.out.println(temp.data);
                    }
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
    }

    private static  void rightView(BNode root){
        if(root == null)
            return;
        else{
            Queue<BNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int count = q.size();
                int qCount = q.size();
                while(count > 0){
                    BNode temp = q.poll();
                    if(count == 1){
                        System.out.println(temp.data);
                    }
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
    }

    private static int minDepth(BNode root){
        if(root == null)
            return 0;
        return 1+ Math.min(minDepth(root.left), minDepth(root.right));
    }

    private static boolean istestBst(BNode root){
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int maxDepth(BNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.min(left,right)+1;
    }


    public static void main(String args[]){
        BtreeOperation b = new BtreeOperation();

        b.root = new BNode(3);
        b.root.left = new BNode(2);
        b.root.right = new BNode(5);
        b.root.left.left = new BNode(7);
 //       b.root.left.right = new BNode(4);
//        b.root.right.left = new BNode(6);
//        b.root.right.right = new BNode(7);
       // b.lot();
        //System.out.println(istestBst(root));
        //minDepth(root);
        //lotNew(root);
        //rightView(root);
        System.out.println("max depth of tree is: " +maxDepth(root));
    }
}
