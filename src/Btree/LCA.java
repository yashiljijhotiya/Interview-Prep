package Btree;

public class LCA {
    private static  BNode root;

    private static BNode lca(BNode root, int n1, int n2){
        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2){
            return  root;
        }
        var leftNode = lca(root.left, n1,n2);
        var rightNode = lca(root.right, n1,n2);

        if(leftNode != null && rightNode != null ){
            return  root;
        }

        if(leftNode == null && rightNode == null)
            return null;
        return  leftNode != null ? leftNode : rightNode;
    }

    private  static int sumNode(BNode root){
        if(root == null){
            return 0;
        }
        return root.data + sumNode(root.left) + sumNode(root.right);
    }

    private static  void sumOfXParent(BNode root, int x){
        if(root == null){
            return;
        }
        int result = 0;
        if((root.left != null && root.data == x) && (root.right != null && root.data == x)){
            result += root.data;
        }
        sumOfXParent(root.left,x);
        sumOfXParent(root.right,x);

        System.out.println(result);
    }

    public static void main(String[] args) {
        LCA l = new LCA();

        l.root = new BNode(1);
        l.root.left = new BNode(2);
        l.root.right = new BNode(3);
        l.root.left.left = new BNode(4);
        l.root.left.right = new BNode(5);
        l.root.right.left = new BNode(2);
        l.root.right.right = new BNode(7);

        System.out.println(sumNode(root));
        sumOfXParent(root,2);
    }
}
