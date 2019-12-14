package interview_question;

public class Genpact2 {

    private static String remoKelement(String str, int k){
        StringBuilder sb = new StringBuilder(str);
        int left = 0;
        int right = 1;
        int count = 0;
        int i  = 0;
        while(i < sb.length()){

            while(left < k) {
                if (sb.charAt(left) == sb.charAt(right)) {
                    count++;
                    if (count == k - 1) {
                        while (left < right) {
                            sb.deleteCharAt(left);
                            left++;
                        }
                    }
                    right++;
                    left++;
                }
               else{
                   if(sb.charAt(left) != sb.charAt(right)){
                       break;
                   }
                }
            }
           i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaabcccbbd";
        System.out.println(remoKelement(str, 3));
    }
}
