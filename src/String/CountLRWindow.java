package String;

public class CountLRWindow {

    private static  int countWindow(String  str){
        int result = 0;
        int lCount = 0, rCount = 0;
        int index = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'R'){
                rCount ++;
            }
            if(str.charAt(i) == 'L'){
                lCount++;
            }
            if(lCount == rCount){
                lCount = 0;
                rCount = 0;
                result ++;
                i = index++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "LRLR";
        System.out.println(countWindow(str));
    }
}
