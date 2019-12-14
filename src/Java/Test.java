package Java;

import java.util.*;

public class Test {

    public  int test(int arr[]){
        Arrays.sort(arr);
        int n = arr.length;
        int res = arr[n-1];
        int i = n-2;
        int x = res;
        while(i >= 0){
            if(arr[i] == x-1){
                i--;
            }
            else{
                res = res + arr[i];
                x = arr[i];
                i--;
            }
        }
      return  res;
    }

    public static void main(String[] args) {
       // int arr [] = {8,7,9, 3, 10, 20,21};
        //Test  t = new Test();
        //System.out.println(t.test(arr));

        TestStatic.A.testA();

    }
}
