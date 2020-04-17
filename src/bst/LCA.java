package bst;

public class LCA {

    private static BstNode findLCA(int n1, int n2, BstNode root){
        if(root == null){
            return null;
        }
        else{
            if(n1 < root.data && n2 < root.data){
               return findLCA(n1,n2, root.left);
            }

            if(n1 > root.data && n2 > root.data){
                return findLCA(n1,n2,root.right);
            }
        }

        return root;
    }
    public static void main(String[] args) {

        BstNode root = new BstNode(20);
        root.left = new BstNode(8);
        root.right = new BstNode(22);
        root.left.left = new BstNode(4);
        root.left.right = new BstNode(12);
        root.left.right.left = new BstNode(10);
        root.left.right.right = new BstNode(14);
        System.out.print( "LCA of 10 & 14 : " + findLCA(10,14,root).data);

    }


}
