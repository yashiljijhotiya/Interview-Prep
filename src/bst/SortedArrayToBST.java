package bst;

public class SortedArrayToBST {

    private static BstNode convertToBST(int arr[]){
        if(arr == null || arr.length == 0){
            return null;
        }
        return constructBST(arr,0,arr.length-1);
    }

    private static BstNode constructBST(int arr[], int left, int right){
        if(left > right){
            return null;
        }
        int mid = left+(right-left)/2;
        BstNode root = new BstNode(arr[mid]);
        root.left = constructBST(arr,left,mid-1);
        root.right = constructBST(arr,mid+1,right);
        return root;
    }

    private static  void printInorder(BstNode root){
        if(root != null){
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
       int arr[] = {-10,-3,0,5,9};
       BstNode root = convertToBST(arr);
       printInorder(root);
    }
}
