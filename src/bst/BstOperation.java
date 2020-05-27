package bst;

public class BstOperation {
    BstNode root = null;
    public  void insert(int data){
        root =  insertRec(data,root);
    }

    public BstNode insertRec(int data, BstNode root ){
        BstNode node  = new BstNode(data);
        if(root == null){
            root = node;
            return root;
        }
        if(root.data < data){
            root.left = insertRec(data,root.right);
        }
        else{
            root.right = insertRec(data,root.left);
        }
        return root;
    }

    public void inorder(){
         inorderRec(root);
    }

    public void inorderRec(BstNode root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(" -> "+root.data);
            inorderRec(root.right);
        }
    }

    private static BstNode deleteNode(BstNode root, int key){
        if(root == null){
            return root;
        }
        if(root.data < key){
            root.right = deleteNode(root.right,key);
        }
        if(root.data > key){
            root.left = deleteNode(root.left, key);
        }
        else {
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left != null && root.right != null){

                BstNode temp = minValue(root.right);
                root.right = deleteNode(root.right,temp.data);
            }
            else{
                BstNode temp = (root.left != null)  ? root.left : root.right;
                root = temp;
            }
        }
        return root;
    }

    private static BstNode minValue(BstNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }


    public static void main(String args[]){
        BstOperation b = new BstOperation();
        b.insert(4);
        b.insert(3);
        b.insert(11);
        b.insert(17);
        b.insert(1);
        b.insert(22);
        b.inorder();

    }
}
