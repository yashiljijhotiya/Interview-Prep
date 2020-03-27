package sliding_window;
// Longest window that contains all distinct characters;

public class LongestWindowDistinctChar {

    private static final int MAX_CHAR = 26;

    private static String longestWindow(String str){
        int len = str.length();
        if(str == null || len == 0){
            System.out.println("String is empty");
            return " ";
        }
        boolean [] lookup = new boolean[MAX_CHAR];
        int beg = 0, end = 0, low = 0, high;
        for(high = 0; high < len; high++){
            if(lookup[str.charAt(high) - 'a']){
                while(str.charAt(high) != str.charAt(low)){
                    lookup[str.charAt(low)-'a'] = false;
                    low++;
                }
                low++;
            }
            else {
                lookup[str.charAt(high) - 'a'] = true;

                if(end - beg < high - low){
                    end = high;
                    beg = low;
                }
            }
        }
        return str.substring(beg,end+1);
    }
    public static void main(String[] args) {
        String str = "abbcdafeegh";
        System.out.println("longest substring contains all distinct character is :" + longestWindow(str));
    }
}
