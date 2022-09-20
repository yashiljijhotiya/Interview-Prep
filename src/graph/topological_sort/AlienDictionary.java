package graph.topological_sort;

import java.util.*;

public class AlienDictionary {

    private static String alienOrder(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        for (String st : words) {
            for (char ch : st.toCharArray()) {
                graph.put(ch, new ArrayList<>());
                inDegree.put(ch, 0);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j), child = word2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break;
                }
            }
        }
        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getKey() == 0) {
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {
            char vertex = sources.poll();
            sb.append(vertex);
            List<Character> children = graph.get(vertex);
            for (char child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        return inDegree.size() != sb.length() ? "" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("char order: " + alienOrder(new String[]{"ba", "bc", "ac", "cab"}));
    }
}
