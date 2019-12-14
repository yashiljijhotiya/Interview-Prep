package String;

public class StringTest {

    static final int Max_Chars = 26;

    private  void testResult(String str){
        int arr [] = new int[Max_Chars];

        for(int i = 0; i < str.length(); i++){
            //System.out.println(str.charAt(i));
            //System.out.println(str.charAt(i)- 'a');
            arr[str.charAt(i)- 'a']++;
          //System.out.println(arr[str.charAt(i)]++);
            //arr[str.charAt(i)]++;
        }

        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    public static void main(String[] args) {
        StringTest st = new StringTest();
        String str = "abaabczz";
        st.testResult(str);

    }
}
