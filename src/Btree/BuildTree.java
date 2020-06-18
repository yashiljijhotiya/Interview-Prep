package Btree;
import java.util.HashMap;
/*Construct Binary Tree from Preorder and Inorder Traversal
*TC: O(n)
* */
public class BuildTree {

    private static int pre_idx = 0;
    private static int[] preorder;
    private static int[] inorder;
    private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    private static BNode buildTree(int [] preorder, int[] inorder){
        preorder = preorder;
        inorder = inorder;
        int index = 0;
        for(int i : inorder){
            map.put(i,index);
        }
        return build(0,inorder.length);

    }

    private static BNode build(int inLeft, int inRight){
        if(inLeft == inRight){
            return null;
        }
        int rootData = preorder[pre_idx];
        BNode root = new BNode(rootData);

        int index = map.get(rootData);
        pre_idx++;
        root.left = build(inLeft,index);
        root.right = build(index+1, inRight);
        return root;
    }
}
