package Btree;

import java.util.*;

public class BtreeUtil {

    protected static void preOrder(BNode root){
        if(root != null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    protected static void postOrder(BNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    protected static void inOrder(BNode root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    protected static void levelOrderTraversal(BNode root){
        if(root == null){
            return;
        }
        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                BNode temp = queue.poll();
                System.out.print(temp.data);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                size--;
            }
            System.out.println();
        }
    }

    protected static void leftView(BNode root){
        if(root == null){
            return;
        }
        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int left = size;
            while (size > 0){
                BNode temp = queue.poll();
                if(size == left){
                    System.out.println(temp.data);
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                size--;
            }
            System.out.println();
        }
    }

    protected static void rightView(BNode root){
        if(root == null){
            return;
        }
        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                BNode temp = queue.poll();
                if(size == 1){
                    System.out.println(temp.data);
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                size--;
            }
            System.out.println();
        }
    }

    protected static void topView(BNode root){
        if(root == null){
           return;
        }
        else {
            TreeMap<Integer, BNode> map = new TreeMap<>();
            Queue<VerOrderNode> queue = new LinkedList<>();
            queue.add(new VerOrderNode(0,root));
            while(!queue.isEmpty()){
                VerOrderNode temp = queue.poll();
                if(!map.containsKey(temp.dist)){
                    map.put(temp.dist, temp.root);
                }
                if(temp.root.left != null){
                    queue.add(new VerOrderNode(temp.dist-1, temp.root.left));
                }
                if(temp.root.right != null){
                    queue.add(new VerOrderNode(temp.dist+1, temp.root.right));
                }
            }

            for(Map.Entry<Integer,BNode> entry : map.entrySet()){
                System.out.println(entry.getValue().data);
            }
        }
    }

    protected static void bottomView(BNode root){
        if(root == null){
            return;
        }
        else {
            TreeMap<Integer,BNode>map = new TreeMap<>();
            Queue<VerOrderNode> queue = new LinkedList<>();
            queue.add(new VerOrderNode(0, root));
            while (!queue.isEmpty()){
                VerOrderNode temp = queue.poll();

                map.put(temp.dist,temp.root);
                if(temp.root.left != null){
                    queue.add(new VerOrderNode(temp.dist-1, temp.root.left));
                }
                if(temp.root.right != null){
                    queue.add(new VerOrderNode(temp.dist+1, temp.root.right));
                }
            }

            for(Map.Entry<Integer,BNode> entry : map.entrySet()){
                System.out.println(entry.getValue().data);
            }
        }
    }

    protected static void diagonalView(BNode root){
        if(root == null){
            return;
        }
        else {
            TreeMap<Integer, List<BNode>> map = new TreeMap<>();
            Queue<VerOrderNode> queue = new LinkedList<>();
            queue.add(new VerOrderNode(0, root));
            while(!queue.isEmpty()){
                VerOrderNode temp = queue.poll();
                if(!map.containsKey(temp.dist)){
                    List<BNode> list = new ArrayList<>();
                    list.add(temp.dist,temp.root);
                }
                else {
                    List<BNode> list = map.get(temp.dist);
                    list.add(temp.root);
                    map.put(temp.dist,list);
                }
                if(temp.root.left != null){
                    queue.add(new VerOrderNode(temp.dist+1, temp.root.left));
                }
                if(temp.root.right != null){
                    queue.add(new VerOrderNode(temp.dist,temp.root));
                }

            }
        }
    }

    protected static int heightOfTree(BNode root){
        if(root == null){
            return 0;
        }
        return Math.max(heightOfTree(root.left), heightOfTree(root.right))+1;
    }

    protected static int sizeOfTree(BNode root){
        if(root == null){
            return 0;
        }
        int left = sizeOfTree(root.left);
        int right = sizeOfTree(root.right);
        return left+right+1;
    }

    protected static int minHeightOfTree(BNode root){
        int minHeight = Integer.MAX_VALUE;
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null){
            minHeight = minHeightOfTree(root.left);
        }
        if(root.right != null){
            minHeight = Math.min(minHeightOfTree(root.right), minHeight);
        }

        return minHeight + 1;
    }

    protected static boolean hasSumPath(BNode root, int sum){
        return hasSum(root,sum,0);
    }

    private static boolean hasSum(BNode root, int sum, int prevSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(prevSum + root.data == sum){
                return true;
            }
            else {
                return false;
            }
        }
        return  hasSum(root.left, sum, root.data + prevSum) || hasSum(root.left, sum, root.data + prevSum);
    }



}
