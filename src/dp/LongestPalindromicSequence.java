package dp;

public class LongestPalindromicSequence {

    private static  int lps(String  str){
        int result = 0, l;
        int n = str.length();
        int temp [][] = new int[n][n];
        for (int i = 0; i < n; i++)
            temp[i][i] = 1;

        for(int j = 2 ;  j < n; j++){
            for(int k = 0; k< n-j+1; k++){
                l = k+j-1;

                if(str.charAt(k) == str.charAt(l) && j == 2){
                    temp[k][l] = 2;
                }
                else if(str.charAt(k) == str.charAt(l)){
                    temp[k][l] = temp[k+1][l-1] + 2;
                }
                else
                    temp[k][l] = Integer.max(temp[k][l-1], temp[k+1][l]);

            }
        }

        return  temp[0][n-1];
    }
    public static void main(String[] args) {
        String str = "geeksforgeeks";

        System.out.println(lps(str));

    }
}
