package Btree;

public class  PrintNodeAtKDistance {

    private static int printNodeAtKDist(BNode root, BNode target, int k){
        if(root == null || target == null || k < 0){
            return -1;
        }
        return printNodeAtKDistUtil(root,target,k);
    }

    private static int printNodeAtKDistUtil(BNode root, BNode target, int k){
        if(root == null){
            return -1;
        }
        if(root == target){
         printNodeAtKLevel(root,k);
         return 0;
        }
        int left = printNodeAtKDistUtil(root.left, target, k);
        if(left != -1){
          if(left + 1 == k){
              System.out.println(root.data);
          }
          else {
              printNodeAtKLevel(root.right,k - 2 - left);
          }
          return left + 1;
        }
        int right = printNodeAtKDistUtil(root.right,target,k);
        if(right != -1){
            if(right + 1 == k){
                System.out.println(root.data);
            }
            else {
                printNodeAtKLevel(root.left, k - 2 - right);
            }
         return right + 1;
        }
        return -1;
    }

    private static void printNodeAtKLevel(BNode root, int k){
        if(root == null){
            return;
        }
        if(k == 0){
            System.out.println(root.data);
        }
        printNodeAtKLevel(root.left, k-1);
        printNodeAtKLevel(root.right, k-1);
    }

    public static void main(String[] args) {
        BNode root = new BNode(2);
        root.left = new BNode(7);
        root.left.left = new BNode(10);
        root.left.right = new BNode(6);
        root.left.right.left = new BNode(5);
        root.left.right.right = new BNode(11);
        root.right = new BNode(9);
        root.right.right = new BNode(3);
        printNodeAtKDist(root, root.left, 2);

    }
}
