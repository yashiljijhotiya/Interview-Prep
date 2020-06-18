package amazon;
import java.util.*;
//TC : m^2(n) where m is the length of words and n is the no. of words in the list
public class WordLadder {

    private static class wordObj{
        String word;
        int len;
        wordObj(String word, int len){
            this.word = word;
            this.len = len;
        }
    }
    private static int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(beginWord.isEmpty() || endWord.isEmpty() || wordList == null || wordList.size() == 0){
            return 0;
        }

        Queue<wordObj> queue = new LinkedList<>();
        queue.add(new wordObj(beginWord,1));

        while (!queue.isEmpty()){
            wordObj curr = queue.poll();
            ListIterator<String> itr = wordList.listIterator();
            while (itr.hasNext()){
                String temp = itr.next();
                if(isAdjacent(curr.word, temp)){
                    itr.remove();
                    queue.add(new wordObj(temp, curr.len +1));
                    if(temp.equals(endWord)){
                        return curr.len + 1;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isAdjacent(String s1, String s2){
        int count =0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 1){
                    return false;
                }
            }

        }
        return count > 1 ? false : true;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
