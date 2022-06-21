package String;

public class StringTest {

//    static final int Max_Chars = 128;
//
//    private  void testResult(String str){
//        int arr [] = new int[Max_Chars];
//
//        for(int i = 0; i < str.length(); i++){
//            //System.out.println(str.charAt(i));
//            //System.out.println(str.charAt(i)- 'a');
//           // arr[str.charAt(i)- 'a']++;
//          //System.out.println(arr[str.charAt(i)]++);
//            arr[str.charAt(i)]++;
//        }
//
//        for(int i = 0 ; i < arr.length; i++){
//            System.out.println(arr[i]);
//        }
//
//    }
//
//    private List<String> getAllTokens(String s){
//        List<String> result = new ArrayList<>();
//        s = s.toLowerCase();
//        if(s.isEmpty()){
//            return result;
//        }
//        else if(s.length() <= 4 && isAllDigit(s)){
//            result.add(s);
//
//        }
//        else if(isMasked(s)){
//            result.add(s);
//            char [] valArray = s.toCharArray();
//            boolean isMaskedFromStarting = valArray[0].isDigit() ? true : false;
//            boolean isMaskedFromEnding = valArray[valArray.length-1].isDigit() ? true : false;
//            if(valArray.length > 4 && valArray[valArray.length-1].isDigit() && valArray[valArray.length -4].isDigit){
//                if(valArray[0].isDigit() && valArray[3].isDigit()){
//                    result.add(s.substring(0,3));
//                }
//                result.add(s.substring(s.length()-4, s.length()-1));
//            }
//
//
//            if(isMaskedFromStarting && !isMaskedFromEnding){
//                StringBuilder sb = new StringBuilder();
//                for(int i = s.length() -1; i > 0; i++){
//                    if(s.charAt(i).isDigit()){
//                        sb.append(s.charAt(i));
//                    }
//                    else{
//                        break;
//                    }
//                }
//                result.add(sb.toString());
//            }
//            else if(!isMaskedFromStarting && isMaskedFromEnding){
//                StringBuilder sb = new StringBuilder();
//                for(int i = s.length() -1; i > 0; i++){
//                    if(s.charAt(i).isDigit()){
//                        sb.append(s.charAt(i));
//                    }
//                    else{
//                        break;
//                    }
//                }
//                result.add(sb.toString());
//            }
//
//
//        }
//        else {
//            getAllSubstring(s);
//        }
//
//        return result;
//
//    }
//
//    private boolean isMasked(String s){
//        if(s.contains("x{2,}")){
//            return true;
//        }
//        return false;
//    }
//
//    private boolean isAllDigit(String s){
//        return true;
//    }
//
//    private String getUnmaskedDigit(String s, int start, int end){
//        for()
//
//    }
//
//    private static void getAllSubstring(String s){
//        List<String> result = new ArrayList<>();
//        for(int i = 0; i <= s.length(); i++){
//            if(i == 1){
//                break;
//            }
//            for(int j = i+1; j <= s.length(); j++){
//                if(j - i > 3){
//                    System.out.println(s.substring(i,j));
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        StringTest st = new StringTest();
//        String str = "12345678";
//        getAllSubstring(str);
//
//        String s[] = str.split(" ");
//        List<String> list = new ArrayList<>();
//        list.addAll(Arrays.asList(s));
//
//    }
}
