package bit_manipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//To find the min no. of developer which have all the skills
public class MinDeveloper {

    public static void main(String[] args) {
        //Map represent the developer and it's skill set
        HashMap<Integer, List<String>> developerSkillMap = new HashMap<>();
        developerSkillMap.put(1, Arrays.asList("Java", "python"));
        developerSkillMap.put(2, Arrays.asList("Java", "Nodejs"));
        developerSkillMap.put(3, Arrays.asList("Go", "python"));
    }
}
