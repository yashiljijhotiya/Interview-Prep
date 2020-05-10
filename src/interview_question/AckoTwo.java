package interview_question;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class AckoTwo {

    public static void main(String args[]) {
//        ArrayUtils.printArray(getStorage(
//                new int[]{0, 1, 0},
//                new int[]{1, 4, 4},
//                new int[]{1, 2, 3, 4, 5},
//                4,
//                new int[3],
//                5
//        ));
    }

    public static int[] getStorage(int connection_from[], int connection_to[], int storage[], int threshold, int ans[],
                                   int connection_nodes) {
        Map<Integer, Integer> disjointSetParentSumMapping = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, Set<Integer>> sets = new HashMap<>();

        for (int i=0; i<connection_nodes; i++) {
            disjointSetParentSumMapping.put(i, storage[i]);
            parentMap.put(i, i);
            Set<Integer> set = new HashSet<>();
            set.add(i);
            sets.put(i, set);
        }

        int edges = connection_from.length;
        for (int i=0; i<edges; i++) {
            int parentA = parentMap.get(connection_from[i]);
            int parentB = parentMap.get(connection_to[i]);

            if (parentA != parentB) {
                disjointSetParentSumMapping.put(
                        parentA,
                        disjointSetParentSumMapping.get(parentA) + disjointSetParentSumMapping.get(parentB)
                );

                for (int node : sets.get(parentB)) {
                    parentMap.put(node, parentA);
                    disjointSetParentSumMapping.remove(node);
                }

                sets.get(parentA).addAll(sets.get(parentB));
                sets.remove(parentB);
            }

            int storageCount = 0;
            for (int sum : disjointSetParentSumMapping.values()) {
                if (sum <= threshold) {
                    storageCount++;
                }
            }
            ans[i] = storageCount;
        }

        return ans;
    }
}
