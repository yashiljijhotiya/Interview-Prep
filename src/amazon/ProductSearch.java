package amazon;

import java.util.*;

public class ProductSearch {

    private static List<List<String>> suggestedProducts(String [] products, String searchWord){
        List<List<String>> ans = new ArrayList<>();
        if (products == null || products.length == 0 || searchWord == null) return ans;
        // build mapping
        HashMap<Integer, List<String>> mapping = buildMapping(products, searchWord);
        // from prefix is whole searchWord to first letter of word
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> (b.compareTo(a)));
        for (int i = searchWord.length() - 1; i >= 0; i--) {
            if (mapping.containsKey(i)) {
                List<String> suggest = mapping.get(i);
                for (String product : suggest) {
                    heap.offer(product);
                    if (heap.size() > 3) heap.poll();
                }
            }
            List<String> list = heap2List(heap);
            ans.add(list);
        }
        Collections.reverse(ans);
        return ans;

    }

    private static List<String> heap2List(PriorityQueue<String> heap) {
        List<String> ans = new ArrayList<>();
        String s1 = heap.poll();
        String s2 = heap.poll();
        String s3 = heap.poll();
        if (s3 != null) {
            ans.add(s3);
            heap.offer(s3);
        }
        if (s2 != null) {
            ans.add(s2);
            heap.offer(s2);
        }
        if (s1 != null) {
            ans.add(s1);
            heap.offer(s1);
        }
        return ans;
    }

    private static HashMap<Integer, List<String>> buildMapping(String[] products, String searchWord) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String product : products) {
            int prefix = 0;
            while (prefix < product.length() && prefix < searchWord.length()
                    && product.charAt(prefix) == searchWord.charAt(prefix)) {
                prefix++;
            }
            List<String> list = map.getOrDefault(prefix - 1, new ArrayList<String>());
            list.add(product);
            map.put(prefix - 1, list);
        }
        return map;
    }
    public static void main(String[] args) {
        String [] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(suggestedProducts(products, "mouse"));

    }
}
