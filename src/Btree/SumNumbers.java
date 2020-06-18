package Btree;

public class SumNumbers {

    private static int sum = 0;
    private static int sumNumbers(BNode root){
        if(root == null){
            return 0;
        }
        findSumPath(root, 0);
        return sum;
    }

    private static void findSumPath(BNode root, int curr){
        if(root == null){
            return;
        }
        curr = curr * 10 + root.data;
        if(root.left == null && root.right == null){
            sum += curr;
        }
        else {
            findSumPath(root.left, curr);
            findSumPath(root.right,curr);
        }
    }
}
