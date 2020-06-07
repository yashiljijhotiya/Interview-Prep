package leetcode;
import java.util.*;

public class KFrequentKeywords {

    private static List<String> findKFrequent(String [] keywords, String [] reviews, int k ){
        Map<String, Integer> freqMap = new HashMap<>();
        HashSet<String> keywordsSet = new HashSet<>(Arrays.asList(keywords));
        for(String review : reviews){
           String [] str = review.split("\\W");
           HashSet<String> added = new HashSet<>();
           for(String s : str){
               s = s.toLowerCase();
               if(keywordsSet.contains(s) && !added.contains(s)){
                   freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
                   added.add(s);
               }
           }
        }
        List<String> list = new ArrayList<>(freqMap.keySet());
        Collections.sort(list, (a,b) -> (freqMap.get(a).equals(freqMap.get(b)) ? a.compareTo(b) : freqMap.get(b)-freqMap.get(a)));

        return list.subList(0, k);

    }

    public static void main(String[] args) {
        int k = 2;
        String[] keywords = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };


        System.out.println(findKFrequent(keywords,reviews,k));
    }
}
