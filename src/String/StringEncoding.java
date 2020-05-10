package String;

public class StringEncoding {

    private static String encodeString(String str){
        // edge case for null check
        if(str == null || str.length() == 0){
            return "";
        }
        char arr[] = str.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 0;
        char prev = ' ';
        for(char c : arr){
            if(c == prev){
                count++;
                prev = c;
            }
            else {
                if(count != 0){
                    result.append(count).append(prev);;
                }
                count = 1;
                prev = c;
            }
        }
        //to append the last character to the result
        result.append(count).append(prev);

        return result.toString();
    }

    public static void main(String[] args) {
        String str =  "aabc";
        System.out.println(encodeString(str));
    }
}
