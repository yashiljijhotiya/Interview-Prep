package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Boggle {

    private static void findWord(char wordBoard [][], boolean visited [][], int row, int col, String word, List<String> dictionary ){
       int pathRow[] = {0,0,1,1,-1,1,-1,-1};
       int pathCol[] = {1,-1,-1,1,1,0,0,-1};
        if(dictionary.contains(word)){
            System.out.println(word);
        }
        if(wordBoard.length == word.length()){
            return;
        }
        for(int i = 0; i < pathRow.length; i++){
            int rowNew = row + pathRow[i];
            int colNew = col + pathCol[i];
            if(isValid(rowNew,colNew,visited)){
                visited[rowNew][colNew] = true;
                findWord(wordBoard,visited,rowNew,colNew, word+ wordBoard[rowNew][colNew],dictionary);
                visited[rowNew][colNew] = false;
            }
        }
    }

    private static  boolean isValid(int rowNew, int colNew, boolean visited[][]){
      if(rowNew < 0 && colNew < 0 && rowNew > visited.length && colNew > visited.length && !visited[rowNew][colNew]){
          return true;
      }
      else {
          return false;
      }

    }

    public static void main(String[] args) {
        char wordBoard [][] = {{'G', 'I', 'z'}, {'U', 'E', 'K'}, {'Q', 'S', 'E'}};
        boolean visited [][]  = new boolean[3][3];
        String word = new String();
        List<String> dictionary = new LinkedList<>();
        dictionary.add("GEEK");
        dictionary.add("QUIZ");
        dictionary.add("GO");
        findWord(wordBoard,visited,0,0,word,dictionary);

    }
}
