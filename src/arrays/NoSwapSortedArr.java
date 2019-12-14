package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NoSwapSortedArr {

    public  class Pair{
        int value;
        int index;
        Pair(int val, int i){
            value = val;
            index = i;
        }
    }


    private  int noOfSwap(int arr[]){
        int result = 0;
        ArrayList<Pair> p = new ArrayList<>();
        boolean visited[] = new boolean[arr.length];
        Arrays.fill(visited, false);
        for(int i = 0; i < arr.length; i++){
            p.add(new Pair(arr[i],i));
        }
      // p.forEach(x -> System.out.println("val: "+x.value +" index: "+ x.index));
        p.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.valueOf(o1.value).compareTo(Integer.valueOf(o2.value));
            }
        });

        for(int i = 0; i < arr.length; i++){
            if(visited[i] || p.get(i).index == i)
                continue;
            int j = i;
            int cycle = 0;
            while(!visited[j]){
                visited[j] = true;
                j = p.get(j).index;
                cycle++;
            }

            if(cycle > 0){
                result += (cycle -1);
            }

        }

        //p.forEach(x -> System.out.println("list after sorting" + "val: "+x.value +" index: "+ x.index));
        return  result;
    }

    public static void main(String[] args) {
        int arr [] = {4,2,1,5,3};
        NoSwapSortedArr a = new NoSwapSortedArr();
        System.out.println(a.noOfSwap(arr));
        ArrayList<Integer> ar = new ArrayList<>();
        Collections.sort(ar);

    }
}
