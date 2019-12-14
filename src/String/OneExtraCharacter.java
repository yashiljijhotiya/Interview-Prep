package String;

public class OneExtraCharacter {

    private static  char extraChar(String s1, String s2){
        int res = 0;

        for(int i = 0; i < s1.length(); i++){
            res ^= s1.charAt(i);
        }

        for(int j = 0; j < s2.length(); j++){
            res ^= s2.charAt(j);
        }
        return ((char)res);
    }

    public static void main(String[] args) {
        String str1 = "acde";
        String  str2 = "ceabd";
        System.out.println("extra char is :" + extraChar(str1, str2));
    }
}
