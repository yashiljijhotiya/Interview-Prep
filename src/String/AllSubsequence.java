package String;

public class AllSubsequence {

    private static String[] findAllSubsequence(String s){
        if(s.length() == 0){
            String ans [] = {" "};
            return ans;
        }
        String smallSubsequence[] = findAllSubsequence(s.substring(1));
        String result[] = new String[smallSubsequence.length*2];
        int k = 0;
        for(int i = 0; i < smallSubsequence.length; i++){
            result[k] = smallSubsequence[i];
            k++;
        }
        for(int i = 0; i < smallSubsequence.length; i++){
            result[k] = s.charAt(0)+smallSubsequence[i];
            k++;
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "1001";
        String res [] = findAllSubsequence(s);
        for (String i : res){
            System.out.println(i);
        }
    }
}
