package String;
/*
Longest subsequence where every character appears at-least k times
Given a string and a number k, find the longest subsequence of a string where every character appears at-least k times.
*/
public class LSWithKCharacters {

    private  static  final int MAx_Chars = 26;

    private void longestSubSequenceWithK(String str, int k){
        int l = str.length();
        int arr[] = new int[MAx_Chars];

        for(int i = 0; i < l; i++){
            arr[str.charAt(i)- 'a']++;
        }

        for(int i = 0; i < l; i++){
            if(arr[str.charAt(i) - 'a'] > k){
                System.out.println(str.charAt(i));
            }
        }

    }
    public static void main(String[] args) {
        LSWithKCharacters l = new LSWithKCharacters();
        String s = "abdddjlmpsspsqpaa";
        l.longestSubSequenceWithK(s, 2);

    }
}
