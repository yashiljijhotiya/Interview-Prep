package Btree;

public class DiameterOfTree {

    private static int treeDiameter = 0;

    private static class Pair{
        int height;
        int diameter;

    }

    private static Pair diameter(BNode root){
        Pair result = new Pair();
        if(root == null){
            Pair p = new Pair();
            p.height = 0;
            p.diameter = 0;
            return p;
        }
        Pair left = diameter(root.left);
        Pair right = diameter(root.right);
        int leftHeight = left.height;
        int rightHeight = right.height;
        int leftDiameter = left.diameter;
        int rightDiameter = right.diameter;

        int height = 1 + Math.max(leftHeight,rightHeight);
        int diameter = Math.max(leftHeight+rightHeight,Math.max(leftDiameter,rightDiameter));
        result.height = height;
        result.diameter = diameter;
        return result;
    }

    private static int findDiameter( BNode root){
        calculateDiameter(root);
        return treeDiameter;
    }

    private static int calculateDiameter(BNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = calculateDiameter(root.left);
        int rightHeight = calculateDiameter(root.right);

        int diameter = leftHeight + rightHeight + 1;
        treeDiameter = Math.max(diameter, treeDiameter);

        return  Math.max(leftHeight,rightHeight) + 1;
    }

    private static int diameterOfBtree(BNode root){
        if(root == null){
            return 0;
        }
        dfs(root);
        return treeDiameter;
    }

    private static int dfs(BNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        treeDiameter = Math.max(treeDiameter, left+right+1);
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(4);
        root.right.left = new BNode(5);
        root.right.right = new BNode(6);
       // System.out.println("diameter : " + diameter(root).diameter);
        //System.out.println("diameter : " + findDiameter(root));
        root.left.left = null;
        root.right.left.left = new BNode(7);
        root.right.left.right = new BNode(8);
        root.right.right.left = new BNode(9);
        root.right.left.right.left = new BNode(10);
        root.right.right.left.left = new BNode(11);
        //System.out.println("diameter : " + diameter(root).diameter);
        //System.out.println("diameter : " + findDiameter(root));

    }
}
