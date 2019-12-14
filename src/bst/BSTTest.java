package bst;

public class BSTTest {

    private  static  BstNode root = null;

    private  void insert(int data){
        root = insertRec(root, data);
    }

    private BstNode insertRec(BstNode root, int data){
        BstNode node = new BstNode(data);
        if(root == null){
            root = node;
            return root;
        }
        else if(root.data < data){
            root.right = insertRec(root.right, data);
        }
        else{
            root.left = insertRec(root.left,data);
        }

        return  root;
    }

    private void inorder(){
        inorderRec(root);
    }

    private void inorderRec(BstNode root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(" " + root.data);
            inorderRec(root.right);
        }
    }

    private void lot(BstNode root){

    }



    public static void main(String[] args) {
        BSTTest t = new BSTTest();
        t.insert(11);
        t.insert(17);
        t.insert(4);
        t.insert(19);
        t.insert(7);
        t.inorder();
    }
}
