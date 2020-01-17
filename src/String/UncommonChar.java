package String;

public class UncommonChar {
    static  final int noOfChar = 26;

    private static  void printUncommon(String s1, String s2){
        int arr[] = new int[noOfChar];
        for(int i = 0; i < s1.length();i++){
            arr[s1.charAt(i) -'a'] = 1;
        }

        for(int j = 0; j < s2.length(); j++){
            var c = s2.charAt(j) - 'a';
            if(arr[c] == 1){
                arr[c] = -1;
            }
            else{
                arr[c] = 1;
            }
        }

        for(int i = 0; i < noOfChar; i++){
            if (arr[i] == 1 || arr[i] == 2)
            {
                System.out.print((char) (i + 'a') + " ");
            }
        }
    }
    public static void main(String[] args) {
        String s1 = "abacade";
        String s2 = "bcdanj";
        printUncommon(s1,s2);
    }
}
