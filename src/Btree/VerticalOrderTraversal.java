package Btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

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
        }

    }

    private static void printBottomView(){

    }

    private static void printTopView(){

    }


    public static void main(String[] args) {

    }
}
