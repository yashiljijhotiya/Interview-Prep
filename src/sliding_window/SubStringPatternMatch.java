package sliding_window;

public class SubStringPatternMatch {

    private static final int NO_CHARS = 256;
    private static String findSubStringWindow(String str, String pat){
        String result = "";
        int len1 = str.length();
        int len2 = pat.length();
        int hash_pat[] = new int [NO_CHARS];
        int hash_str[] = new int [NO_CHARS];


        if(len1 < len2){
            System.out.println("no such window exist");
            return result;
        }
        for(int i = 0; i < len2; i++){
            hash_pat[pat.charAt(i)]++;
        }

        int start = 0, start_index =-1, min_length = Integer.MAX_VALUE, count = 0;

        for(int j = 0; j < len1; j++){
            hash_str[str.charAt(j)]++;

            if(hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)]){
                count++;
            }

            if(count == len2){

                while(hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0){
                    if(hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                int windowLen = j - start + 1;
                if(min_length > windowLen){
                    min_length = windowLen;
                    start_index = start;
                }
            }
        }
        if(start_index == -1){
            System.out.println("No such window exist");
            return result;
        }

        return str.substring(start_index, start_index + min_length);
    }

    private static String findMinWindow(String s, String t){
        if(s.length() < t.length()){
            return "";
        }
        int start = 0, count = 0, minLength = Integer.MAX_VALUE, minStart = -1, minEnd = 0;
        int charMap[] = new int[128];
        for(char c : s.toCharArray()){
            charMap[c]++;
        }
        for(int end = 0; end < s.length(); end++){
            if(charMap[s.charAt(end)] > 0){
                count++;
            }
            charMap[s.charAt(end)]--;

            if(count == t.length()){
                while(start < end && charMap[s.charAt(start)] < 0){
                    charMap[s.charAt(start)]++;
                    start++;
                }
                if(minLength  > end - start +1){
                    minLength = end - start + 1;
                    minStart = start;
                    minEnd = end + 1;
                }
                charMap[s.charAt(start)]++;
                start++;
                count--;
            }
        }
       return  minStart != -1 ? "" : s.substring(minStart, minEnd);
    }

    public static void main(String[] args) {
        String str = "adobecodebanc";
        String pat = "abc";

//        System.out.print("Smallest window is :\n " +
//                findSubStringWindow(str, pat));
        System.out.println(findMinWindow(str,pat));

    }
}
