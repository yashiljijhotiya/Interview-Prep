package bst;
 //TC : n *log(n)
public class IsBalanced {

    private static boolean isBalanced(BstNode root){
        if(root == null){
            return true;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.abs(lHeight - rHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(BstNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }

}
