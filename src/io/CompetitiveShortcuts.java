package io;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CompetitiveShortcuts {

    public static void main(String[] args) {
        int arr [] = {5,11,7,2,32,1,19};
        Arrays.sort(arr);// used to sort element of array { For primitives, Arrays.sort() uses dual pivot quicksort algorithms. }
        System.out.println(Arrays.toString(arr));

        System.out.println((arr[1] & 1) == 0 ?  "EVEN" : "ODD" ); // for checking odd even
    }
}
