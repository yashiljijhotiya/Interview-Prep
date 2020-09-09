package amazon;
//TC : max* n
public class Walmart {


    /* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

//import java.util.Scanner;
//
//    class TestClass {
//        public static void main(String args[] ) throws Exception {
//            try(Scanner scanner = new Scanner(System.in)) {
//                int tests = scanner.nextInt();
//                for (int i=0; i<tests; i++) {
//                    int rows = scanner.nextInt();
//                    int columns = scanner.nextInt();
//
//                    int arr[][] = new int[rows][columns];
//
//                    for (int x=0; x<rows; x++) {
//                        for(int y=0; y<columns; y++) {
//                            arr[x][y] = scanner.nextInt();
//                        }
//                    }
//                    System.out.println(run(arr));
//                }
//            }
//        }
//
//        private static int run(int arr[][]) {
//            boolean pickedItems[] = new boolean[arr[0].length];
//            int minPrice = 0;
//            for (int shop=0; shop<arr.length; shop++) {
//                minPrice += minSum(arr[shop], pickedItems);
//            }
//            int notPicked = -1;
//            for (int i=0; i<pickedItems.length; i++) {
//                if (!pickedItems[i]) {
//                    notPicked = i;
//                    break;
//                }
//            }
//
//            if (notPicked == -1) {
//                return minPrice;
//            }
//
//                int minColValue = Integer.MAX_VALUE;
//                int minIndex = Integer.MAX_VALUE;
//                for (int i=0; i<arr.length; i++) {
//                    if (arr[i][notPicked] < minColValue) {
//                        minColValue = arr[i][notPicked];
//                        minIndex = i;
//                    }
//                }
//
//                minPrice += arr[minIndex][notPicked];
//                int maxValueSelect = Integer.MIN_VALUE;
//
//                for (int i=0; i<arr[0].length; i++) {
//                    if (maxValueSelect < arr[minIndex][i]) {
//                        maxValueSelect = arr[minIndex][i];
//                    }
//                }
//                minPrice -= maxValueSelect;
//
//            return minPrice;
//        }
//
//        private static int minSum(int arr[], boolean pickedItems[]) {
//            int maxIndex = -1, maxValue = Integer.MIN_VALUE, sum = 0;
//            for (int i=0; i<arr.length; i++) {
//                if (maxValue < arr[i]) {
//                    maxIndex = i;
//                    maxValue = arr[i];
//                }
//                sum += arr[i];
//            }
//            for (int i=0; i<arr.length; i++) {
//                if (maxIndex != i) {
//                    pickedItems[i] = pickedItems[i] || true;
//                }
//                if (maxIndex == i) {
//                    sum -= arr[i];
//                }
//
//            }
//            return sum;
//        }
//
//
//    }

    private static  int findCoPrime(int arr[]){
        int max = Integer.MAX_VALUE;
        int coPrime = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        for(int i = 2; i < max; i++){
            int j = 0;
            while (j < arr.length){
                int gcd = gcd(arr[j],i);
                if(gcd != 1){
                    break;
                }
                j++;
                if(j == arr.length){
                    coPrime = i;
                }
            }
            if(coPrime != 0){
                return coPrime;
            }
        }
        return coPrime;
    }

     private static int gcd(int a, int b){
         if(b == 0){
             return a;
         }
         return gcd(b, a%b);
     }

  public static void main(String[] args) {
    int arr[] = {5,7,25};
    System.out.println(findCoPrime(arr));
  }
}
