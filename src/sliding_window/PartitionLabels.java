package sliding_window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

    private static List<Integer> findPartition(String str){
        if(str == null || str.length() == 0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        char[] charArr = str.toCharArray();
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < charArr.length; i++){
            indexMap.put(charArr[i], i);
        }
        int windowEnd, windowStart = 0;
        for(windowEnd = 0; windowEnd <= charArr.length; windowEnd++){
            char rightChar = charArr[windowEnd];
            int mostRightIndex = indexMap.get(rightChar);

            while (windowEnd < mostRightIndex){
                rightChar = charArr[windowEnd];
                mostRightIndex = Math.max(mostRightIndex, indexMap.get(rightChar));
                windowEnd++;
            }
            result.add(windowEnd - windowStart + 1);
            windowStart = windowEnd + 1;

        }

        return result;
    }

    public static void main(String[] args) {
        String str = "aabacccd";
        System.out.println(findPartition(str));
    }
}
