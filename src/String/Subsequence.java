package String;

public class Subsequence {

    private  boolean isSubsequence(String s1, String s2, int m, int n){
        if(m == 0)
            return false;
        if(n == 0)
            return true;
        if(s1.charAt(m-1) == s2.charAt(n-1))
            return isSubsequence(s1, s2, m-1, n-1);

        return isSubsequence(s1, s2, m-1, n );

    }

    public static void main(String[] args) {
        Subsequence s = new Subsequence();
        String s1 = "yashil";
        String s2 = "shu";
        if(s.isSubsequence(s1, s2, s1.length(), s2.length())){
            System.out.println(s2+ " : S2 is a subsequence of s1 : " + s1);
        }
        else {
            System.out.println("s2 is not subsequence of s1");
        }

    }
}
