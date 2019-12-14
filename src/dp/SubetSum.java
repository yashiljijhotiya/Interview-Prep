package dp;

import java.util.HashMap;

public class SubetSum {

    int count = 0;
    private int countNOOfSubSet(int arr[],int total){
        HashMap<String,Integer> hs = new HashMap<>();
        int n = arr.length-1;
        return countSubSet(arr,total,n,hs);
    }


    private int countSubSet(int arr[], int total, int l, HashMap<String ,Integer> hs){

        String key = total + ":" + l;
        if(hs.containsKey(key)){
            return hs.get(key);
        }
        if(total == 0){
            return 1;
        }
        else if(l < 0 || total < 0){
            return 0;
        }
        else if(arr[l] > total){
          count = countSubSet(arr,total,l-1,hs);
        }
        else{
            count = countSubSet(arr,total,l-1,hs)+ countSubSet(arr,total-arr[l],l-1,hs);
        }

       hs.put(key,count);
        return count;
    }


    public static void main(String[] args) {
        SubetSum s = new SubetSum();
        int arr [] = {2,4,6,8,10};
        int total = 16;
        System.out.println("no. subset possible are " + s.countNOOfSubSet(arr,total));

    }
}
