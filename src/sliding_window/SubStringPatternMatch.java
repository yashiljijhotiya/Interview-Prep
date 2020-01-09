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

    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :\n " +
                findSubStringWindow(str, pat));

    }
}
