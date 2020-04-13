package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FirstRepeatingWord {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the length of  string");
        int num = Integer.parseInt(br.readLine());
        String s= br.readLine();
        System.out.println(s);
        HashMap<String, Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();

        for(String str : s.split(", ")){
            if(!hs.contains(str)){
                hs.add(str);
            }
            else{
                System.out.println("first repeated word in a string is : " + str);
                break;
            }
        }

    }
}
