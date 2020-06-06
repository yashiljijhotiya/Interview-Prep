package amazon;

public class TreasureIsland {

    private static int distance = Integer.MAX_VALUE;

    private static int findShortestRoute(char [][] island){
        if(island == null || island.length == 0){
            return 0;
        }
        boolean [][] visited = new boolean[island.length][island[0].length];
        dfs(island,visited,0,0,0);
        return distance;
    }

    private static void dfs(char [][] island, boolean [][] visited, int r, int c, int levelDistance){

        if(r < 0 || r >= island.length || c < 0 || c >= island[0].length || island[r][c] == 'D' || visited[r][c]){
            return;
        }

        if(island[r][c] == 'X'){
           distance = Math.min(distance,levelDistance);
           return;
        }

        visited[r][c] = true;

        dfs(island, visited, r, c - 1, levelDistance + 1);
        dfs(island,visited, r,c + 1, levelDistance + 1);
        dfs(island, visited, r - 1, c, levelDistance + 1);
        dfs(island, visited, r + 1, c, levelDistance + 1);

        visited[r][c] = false;
    }

    public static void main(String[] args) {
        char [][] island = { {'O', 'O', 'O', 'O'},
                             {'D', 'O', 'D', 'O'},
                             {'O', 'O', 'O', 'O'},
                             {'X', 'D', 'D', 'O'} };
        System.out.println("shortest route to the treasure is  : " + findShortestRoute(island));
    }
}
