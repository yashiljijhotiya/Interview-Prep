package sliding_window;

import java.util.Arrays;

public class PermutationString {

    private static boolean isPermutation(String s1, String s2){
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2){
            return false;
        }
        int hash1 [] = new int[26];
        int hash2[] = new int[26];

        int left = 0, right = 0;
        while (right < l1){
            hash1[s1.charAt(right) - 'a']++;
            hash2[s2.charAt(right) - 'a']++;
            right++;
        }
        right = right - 1;
        while (right < l2){
            if(Arrays.equals(hash1,hash2)){
                return true;
            }
            right += 1;
            if(right != l2){
                hash2[s2.charAt(right) -'a']++;
            }
            hash2[s2.charAt(left)-'a']--;
            left++;
        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println("Permutation exist: " + isPermutation( "abc", "oidbcaf"));
        System.out.println("Permutation exist: " + isPermutation("dc","odicf"));
        System.out.println("Permutation exist: " + isPermutation("bcdyabcdx","bcdxabcdy"));
        System.out.println("Permutation exist: " + isPermutation("abc","aaacb"));
    }
}
