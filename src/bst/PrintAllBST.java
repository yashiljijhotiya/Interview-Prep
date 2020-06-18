package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllBST {

    private static List<BstNode> generateTrees(int n){
        if(n == 0){
            return new ArrayList<BstNode>();
        }
        return generateTree(1, n);
    }

    private static List<BstNode> generateTree(int beg, int end){
        List<BstNode> result = new ArrayList<>();
        System.out.println(beg + " -- " + end);
        if(beg > end){
            result.add(null);
            return result;
        }
        for(int i = beg; i <= end; i++) {
            List<BstNode> leftChildren = generateTree(beg, i-1);
            List<BstNode> rightChildren = generateTree(i+1,end);

                for(BstNode leftChild : leftChildren){
                for(BstNode rightChild : rightChildren){
                    BstNode root = new BstNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    result.add(root);
                }
            }
        }
      return result;
    }
    public static void main(String[] args) {
        List<BstNode> list = generateTrees(2);
        list.forEach(i -> System.out.println(i.data));

    }
}
