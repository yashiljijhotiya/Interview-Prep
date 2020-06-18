package Btree;

public class DPTreeSyntax {

    private static int solve(BNode root){
        if(root == null){
            return 0;
        }
        int result = 0;//result value can be changed i.e. Integer.MIN_VALUE, MAX_VALUE

        return result;
    }

    private static int getRes(BNode root, int res){
        //Base condition
        if(root == null){
            return 0;
        }
        //Hypothesis
        int l = getRes(root.left, res);
        int r = getRes(root.right, res);
        //Induction

        // for diameter
        int temp = Math.max(l,r)+1;
        int ans = Math.max(temp, l+r+1);
        res = Math.max(ans, res);

       //for max sum path for any node
        temp = Math.max(Math.max(l,r) + root.data, root.data);
        ans = Math.max(temp, l+r+root.data);
        res = Math.max(ans, temp);

        //for max path sum from leaf node
        temp = Math.max(l,r) + root.data;
        ans = Math.max(temp, l + r + root.data);
        res = Math.max(temp,ans);


        return temp;
    }
    public static void main(String[] args) {

    }
}
