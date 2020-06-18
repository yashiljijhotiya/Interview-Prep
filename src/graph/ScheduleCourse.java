package graph;

import java.util.*;

public class ScheduleCourse {

    private static HashMap<Integer, List<Integer>> adjList;
    private static int inDegree[];

    private static boolean canFinishAllCourses(int courses, int prereq[][]){
        inDegree = new int[courses];
        adjList = new HashMap<>();

        for(int i = 0; i < courses; i++){
            adjList.put(i, new ArrayList<>());
            inDegree[i] = 0;
        }
        buildGraph(courses,prereq);
        Queue<Integer> sources = new LinkedList<>();
        for(int i : inDegree){
            if(i == 0){
                sources.add(i);
            }
        }

        int count = 0;
        while (!sources.isEmpty()){
            int vertex = sources.poll();
            count++;
            List<Integer> children = adjList.get(vertex);
            for(int child : children){
                if(inDegree[child] - 1 == 0){
                    sources.add(child);
                }
            }
        }
        return courses == count;
    }

    private static void buildGraph(int vertices, int connection[][]){
        for(int i = 0; i < connection.length; i++){
            int parent = connection[i][0];
            int child = connection[i][1];
            adjList.get(parent).add(child);
            inDegree[child]++;
        }
    }
    public static void main(String[] args) {
     int prereq[][] = {{1,0}};
        System.out.println(canFinishAllCourses(2, prereq));
    }
}
