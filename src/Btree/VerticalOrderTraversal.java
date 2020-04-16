package Btree;

import java.util.*;

public class VerticalOrderTraversal {

    private static TreeMap<Integer, List<BNode>> disMap = new TreeMap<>();
    private static Queue<VerOrderNode> q = new LinkedList<>();

    private  static void verticalOrderTraversal(BNode root){
        if(root == null)
            return;
        else{
            q.add(new VerOrderNode(0,root));
            while(!q.isEmpty()){
                VerOrderNode node = q.poll();
                if(disMap.containsKey(node.dist)){
                   List<BNode> list = disMap.get(node.dist);
                   list.add(node.root);
                   disMap.put(node.dist, list);
                }
                else{
                    List<BNode> l = new LinkedList<>();
                    l.add(node.root);
                    disMap.put(node.dist,l);
                }
                if(node.root.left != null){
                    q.add(new VerOrderNode(node.dist-1, node.root.left));

                }
                if(node.root.right != null){
                    q.add(new VerOrderNode(node.dist+1, node.root.right));
                }
            }

            for(Map.Entry<Integer, List<BNode>> entry : disMap.entrySet()){
                entry.getValue().forEach(i -> {
                    System.out.print(i.data + "  ");
                });
                System.out.println();
            }
        }

    }

    private static void printBottomView(){

        for(Map.Entry<Integer, List<BNode>> entry : disMap.entrySet()){
            System.out.println(entry.getValue().get(0).data);
        }
    }

    private static void printTopView(){

    }


    public static void main(String[] args) {
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.left.right = new BNode(5);
        root.right.left = new BNode(6);
        root.right.right = new BNode(7);
        root.right.left.right = new BNode(8);
        root.right.right.right = new BNode(9);
        System.out.println("Vertical Order traversal is");
        verticalOrderTraversal(root);
        //Top view 4,2,1,3,7,9
        System.out.println("Top view of Binary Tree is :");
        BtreeUtil.topView(root);
        //Bottom view 4,2,6,8,7,9
        System.out.println("Bottom view of Binary Tree is :");
        BtreeUtil.bottomView(root);




    }


}
