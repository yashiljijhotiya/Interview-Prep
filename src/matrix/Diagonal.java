package matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* @author : Yashil(18-04-20)
 *  Leetcode
 */

public class Diagonal {

    private static int[] printDiagonally(int mat[][]){
        if(mat == null || mat.length == 0){
            return new int[]{};
        }

        int m = mat.length, n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>(m+n);
        List<Integer> res = new ArrayList<>();
        for(int i  = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!map.containsKey(i+j)){
                    map.put(i+j, new ArrayList<>());
                }
                map.get(i+j).add(mat[i][j]);
            }
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            res.addAll(entry.getValue());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        int mat[][] = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        int res[] = printDiagonally(mat);
        for(int i : res){
            System.out.print(i + " ");
        }


    }
}
