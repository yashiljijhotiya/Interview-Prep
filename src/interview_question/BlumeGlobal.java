package interview_question;

public class BlumeGlobal {
    private static final int MAX_CHAR = 26;

    private static int minWindow(String str){
        int  beg = 0, end = 0, low = 0, high;
        int len = str.length();
        boolean lookup[] = new boolean[MAX_CHAR];
        if(str == null || len == 0){
            return 0;
        }

        for(high = 0; high < len; high++){
            if(lookup[str.charAt(high) - 'a']){
                while(str.charAt(high) != str.charAt(low)){
                    lookup[str.charAt(low) - 'a'] = true;
                    low++;
                }
                low++;
            }
            else{
                lookup[str.charAt(high) - 'a'] = true;

                if(end - beg < high - low){
                    end = high;
                    beg = low;
                }

            }
        }

        return end-beg+1;
    }
    public static void main(String[] args) {
        System.out.println(minWindow("cccb"));
        System.out.println(minWindow("aabcada"));
//        System.out.println(minWindow("aabcce"));
//        System.out.println(minWindow("dabbcabcd"));
//        System.out.println(minWindow("asdfkjeghfalawefhaef"));
    }
}
