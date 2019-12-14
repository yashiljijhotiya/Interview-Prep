import java.util.Arrays;

public class Test {

    private static final int Max_Chars = 128;

    private  static  void stairPattern(int n){
        int c = 1;
        int j = 1;
        for(int i = n; i > 0; i--){
            while(j <= n){
                if(j <= i-c){
                    System.out.print(" ");
                }
                else{
                    System.out.print("#");
                }
                c++;
                j++;
            }
            System.out.println();
        }

    }

    private static String twoStrings(String s1, String s2){
        int arr[] = new int [Max_Chars];
        String  s = "";
        Arrays.fill(arr,0);
        for(int i = 0; i < s1.length(); i++){
            arr[s1.charAt(i)]++;
        }

        for(int j = 0 ; j < s2.length(); j++){
            if(arr[s2.charAt(j)] != 0){
                s = "YES" ;
                break;
            }
        }

        if(s.equals("YES"))
            return s;
        else
            return "NO";
    }
    public static void main(String args[]){
       stairPattern(3);
       String s1 = "hello";
       String s2 = "world";
       String s3 = "hi";
       String s4 = "world";
       System.out.println(twoStrings(s1, s2));
        System.out.println(twoStrings(s3, s4));
    }
}
