package disjoint_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//HackerRank Merging Communities
public class MergingCommunities {

    private static Map<Integer, Integer> parentMap = new HashMap<>();
    private static Map<Integer, Set<Integer>> communitySet = new HashMap<>();


    private static  void printQueryResult(int noOfCommunities, String query[]){

        for(int i = 1; i <= noOfCommunities; i++){
            parentMap.put(i,i);
            Set<Integer> set = new HashSet<>();
            set.add(i);
            communitySet.put(i,set);
        }

        for(String s : query){
            if(s.contains("M")){
                //mergeCommunity();
                System.out.println(s);
            }
            else{
                //countCommunitySize();
            }
        }
    }

    private static void countCommunitySize(int c){
        int parent = findParent(c);
        Set<Integer> community = communitySet.get(parent);
        System.out.println(community.size());
    }

    private static void mergeCommunity(int a, int b){
        if(parentMap.get(a) == a && parentMap.get(b) == b){
            parentMap.put(b,a);
            Set<Integer> s1 = communitySet.get(a);
            Set<Integer> s2 = communitySet.get(b);
            Set<Integer> merge = new HashSet<>(){{
                addAll(s1);
                addAll(s2);}};

            communitySet.put(a, merge);
            communitySet.remove(b);
        }
        else {
            int parentA = findParent(a);
            int parentB = findParent(b);
            if(parentA == parentB){
                return;
            }
            else {
                parentMap.put(parentA, parentB);
                Set<Integer> setA = communitySet.get(parentA);
                Set<Integer> setB = communitySet.get(parentB);
                Set<Integer> merge = new HashSet<>(){{
                    addAll(setA);
                    addAll(setB);
                }};
             }
        }

    }


    private static int findParent(int c){
        if(parentMap.get(c) != c){
            countCommunitySize(parentMap.get(c));
        }
        return c;
    }

    public static void main(String[] args) {
        int noOfCommunity = 3;
        String query[] = new String[6];
        query[0] = "Q 1";
        query[1] = "M 1 2";
        query[3] = "Q 2";
        query[4] = "M 2 3";
        query[5] = "Q 2";
        printQueryResult(noOfCommunity,query);

    }
}
