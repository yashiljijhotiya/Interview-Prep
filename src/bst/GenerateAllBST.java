package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC : will be equal to catalan no.
public class GenerateAllBST {

    private static List<BstNode> generateBst(int n){
      if(n == 0){
        return new ArrayList<>();
      }

      return generateTree(1,n);
    }

    private static List<BstNode> generateTree(int beg, int end){
      List<BstNode> result = new ArrayList<>();
      if(beg > end){
        result.add(null);
        return result;
      }
      for(int i = beg; i <= end; i++){
        List<BstNode> leftTree = generateTree(beg, i-1);
        List<BstNode> rightTree = generateTree(i+1, end);

        for(BstNode left : leftTree){
          for(BstNode right : rightTree){
            BstNode root = new BstNode(i);
            root.left = left;
            root.right = right;
            result.add(root);
          }
        }

      }

      return result;

    }

  public static void main(String[] args) {
    System.out.println(generateBst(3));
    //
  }
}
