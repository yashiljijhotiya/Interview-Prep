package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    private static List<Integer> findAllAnagram(String s1, String s2 ){
        int l1 = s1.length(), l2 = s2.length();
        List<Integer> result = new ArrayList<>();
//        if(l1 < l2){
//            return new ArrayList<>();
//        }
        int hash1 [] = new int[128];
        int hash2[] = new int[128];

        int left = 0, right = 0;
        while (right < l1){
            hash1[s1.charAt(right) - 'a']++;
            hash2[s2.charAt(right) - 'a']++;
            right++;
        }
        right = right - 1;
        while (right < l2){
            if(Arrays.equals(hash1,hash2)){
                result.add(left);
            }
            right += 1;
            if(right != l2){
                hash2[s2.charAt(right) -'a']++;
            }
            hash2[s2.charAt(left)-'a']--;
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAllAnagram("abcdebacb","cab"));
    }
}
