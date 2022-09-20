package graph.topological_sort;

import java.util.Arrays;

public class PrintAllTaskSchedulingOrder {

    private static boolean isAdjacent(String w1, String w2) {
        if (w1.length() - w2.length() > 0) {
            return false;
        }
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for (int i = 0; i < w1.length(); i++) {
            int a =  w1.charAt(i) - 'a';
            int b =  w1.charAt(i) - 'a';
            System.out.println("w1" + a);
            System.out.println("w2" + b);
            arr[w1.charAt(i) - 'a']++;
            arr[w2.charAt(i) - 'a']--;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            System.out.println();
        }
        System.out.println(count);

        return count == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.print(isAdjacent("aacb", "abav"));
    }
}

//    *
//            * To execute Java, please define "static void main" on a class
// * named Solution.
//            *
//            * If you need more classes, simply define them inline.
//            */
//
///*
//input:
//availableWords = ["warm",”code”,"card",”come”,"cord",”ward”,”wet”] ; //set of few thousand-words
//beginWord = “cold”;
//endWord = “warm”;
//
//output:
//The shortest transformation is cold -> cord -> card -> ward -> warm
//
//rules:
//begin word is not in the set of available words
//each transformed word and end word must exist in availableWords
//adjacent words in the transformation differ by one letter
//*/
//
//    /*
//    Algoritm (Approach the problem):
//     -> This is basically a graph traversal problem in which we know the starting node (beginWord = “cold”) and the ending node or destination (endWord = “warm”).
//     -> Traveserse the dictionary and find the adjacent elem which differ by one letter.
//     Adj List
//     -> Map<String, List<String>> -> "cold" -> {"cord", "cond", ..10}
//                                     "cord" -> { "card", 2}
//
//     -> this adjacent now become current node we will above one step until we found the dest.
//
//
//    */
//// aabb abbx
//    class Solution {
//        private static boolean isAdjacent(String w1, String w2){
//            if(w1.length() - w2.length() > 0){
//                return false;
//            }
//            int [] arr = new int [126];
//            for(int i = 0; i < w1.length(); i++){
//                arr[w1.charAt(i) - 'a']++;
//                arr[w2.charAt(i) - 'a']--;
//            }
//
//            int count = 0;
//            for(int i = 0; i < arr.length; i++){
//                count += arr[i];
//            }
//
//            return count == 1 ? true : false;
//        }
//
//        public static void main(String[] args) {
//            ArrayList<String> strings = new ArrayList<String>();
//            System.out.print(isAdjacent("aabb", "abax"));
//
//        }
//    }
//
//}
