// Next Greater Element GFG
package arrays;

import java.util.Stack;

public class NGE {

    private void nextGreaterElem(int arr[]){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        int elem, next;
        for(int i = 1; i < n; i++){
            next = arr[i];
            if(!s.isEmpty()){
                elem = s.pop();
                while(elem < next){
                    System.out.println(elem + "--> " + next );
                    if(s.isEmpty()){
                        break;
                    }
                    elem = s.pop();

                }

                if(elem > next ){
                    s.push(elem);
                }
            }
            s.push(next);

        }
        while (!s.isEmpty())
        {
            elem = s.pop();
            next = -1;
            System.out.println(elem + " -- " + next);
        }
    }


    public static void main(String[] args) {
        NGE n = new NGE();
        int arr[] = { 11, 13, 21, 3 };
        System.out.println(" next greater element of each element int the arr is:");
        n.nextGreaterElem(arr);
    }
}
