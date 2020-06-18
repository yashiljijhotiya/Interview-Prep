package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/* @author : Yashil(18-04-20)
*  Leetcode
*/

public class ZigZag {

    private static int[] printZigZag(int mat[][]){

        if(mat == null || mat.length == 0) {
            return new int[] {};
        }

        int m = mat.length, n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>(m+n);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i+j).add(mat[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < map.size(); i++) {
            List<Integer> tmp = map.get(i);
            if((i&1) == 0) {
                Collections.reverse(tmp);
            }
            res.addAll(tmp);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {

        int mat [][] = {{1,2},
                        {4,5},
                        {7,8}};
        int res[] = printZigZag(mat);

        for(int i : res){
            System.out.print(i + " ");
        }

    }
}
