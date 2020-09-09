package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  FindAllAnagrams {

    private static final int MAX_CHARACTERS = 26;
    private static List<Integer> findAllAnagram(String s, String p ){
        int l1 = s.length(), l2 = p.length();
        List<Integer> result = new ArrayList<>();
        if(l1 < l2){
            return  result;
        }
        int hash1[] = new int[MAX_CHARACTERS];
        int hash2[] = new int[MAX_CHARACTERS];

        int left = 0, right = 0;
        while (right < l2){
            hash1[s.charAt(right) - 'a']++;
            hash2[p.charAt(right) - 'a']++;
            right++;
        }
        right = right - 1;
        while (right < l1){
            if(Arrays.equals(hash1,hash2)){
                result.add(left);
            }
            right += 1;
            if(right != l1){
                hash1[s.charAt(right) -'a']++;
            }
            hash1[s.charAt(left)-'a']--;
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAllAnagram("abcdebacb","cab"));
    }
}
