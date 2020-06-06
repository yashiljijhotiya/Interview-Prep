package matrix;

import java.util.PriorityQueue;

public class KthElementInSortedMatrix {

    static class Node{
        int r;
        int c;
        int val;
        Node(int r, int c, int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    private static int findKthSmallest(int mat[][], int k){
        int r = mat.length;
        int c = mat[0].length;
        if(mat == null || r == 0 || k < 0 || k > r*c){
            return -1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < c; i++){
            pq.add(new Node(0,i,mat[0][i]));
        }
        for(int i = 0; i < k-1; i++){
            Node node = pq.poll();
            if(node.r == r-1){
                continue;
            }
            pq.offer(new Node(node.r+1, node.c,mat[node.r+1][node.c]));
        }
        return pq.poll().val;
    }

    public static void main(String[] args) {
     int mat [] [] = {{1,5,9},
                      {10,11,13},
                      {12,13,15}};
        System.out.println(findKthSmallest(mat,6));
    }
}
