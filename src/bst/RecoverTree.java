package bst;

import java.util.ArrayList;
import java.util.List;

public class RecoverTree {

    private static void recoverTree(BstNode root){
        if(root == null){
            return;
        }
        List<Integer> inorderList = new ArrayList<>();
        inorder(root,inorderList);
        int [] swapped = findSwapped(inorderList);
        recover(root,2,swapped[0],swapped[1]);
    }

    private static void inorder(BstNode root, List<Integer> inorderList){
        if(root == null){
            return;
        }
        inorder(root.left, inorderList);
        inorderList.add(root.data);
        inorder(root.right,inorderList);
    }

    private static void recover(BstNode root, int count, int x, int y){
        if(root != null){
            if(root.data == x || root.data == y){
                root.data = root.data == x ? y : x;
                if(--count == 0){
                    return;
                }
            }
            recover(root.left, count,x,y);
            recover(root.right,count,x,y);
        }
    }

    private static int[] findSwapped(List<Integer> inorderList){
        int n = inorderList.size();
        int x  = -1, y = -1;
        for(int i = 0; i < n; i++){
            if(inorderList.get(i+1) < inorderList.get(i)){
                y = inorderList.get(i + 1);
                if( x == -1){
                    x = inorderList.get(i);
                }
                else {
                    break;
                }
            }
        }
        return new int[]{x,y};
    }
    public static void main(String[] args) {

    }
}
