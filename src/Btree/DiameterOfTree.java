package Btree;

public class DiameterOfTree {

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

    public static void main(String[] args) {

    }
}
