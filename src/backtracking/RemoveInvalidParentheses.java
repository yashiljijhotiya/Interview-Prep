package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*LeetCode
*O(m * L ^ K), k is num of braces to remove, L is num of removable braces
* */
public class RemoveInvalidParentheses {

    private static HashSet<String> resultSet = new HashSet<>();
    private static int min = Integer.MAX_VALUE;
    private static List<String> result = new ArrayList<>();

    private static List<String> removeInvalidParentheses(String s){
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        //dfs(s, new StringBuilder(),0,0,0,0);
        optimizedDFS(s,0,0, '(', ')');
        //return new ArrayList<>(resultSet);
        return result;
    }

    private static void dfs(String s, StringBuilder sb, int leftBracket, int rightBracket, int index, int count){
        if(count > min){
            return;
        }
        if(leftBracket < rightBracket){
            return;
        }
        if(index == s.length()){
            if(leftBracket == rightBracket){
                if(count < min){
                    resultSet.clear();
                }
                resultSet.add(sb.toString());
                min = count;
            }
            return;
        }

        if(s.charAt(index) == '(' || s.charAt(index) == ')' ){
            dfs(s,sb,leftBracket,rightBracket,index+1,count+1);

            sb.append(s.charAt(index));
            dfs(s, sb,s.charAt(index) == '(' ? leftBracket + 1 : leftBracket, s.charAt(index) == ')' ? rightBracket + 1 : rightBracket, index + 1, count);
        }
        else {
            sb.append(s.charAt(index));
            dfs(s, sb, leftBracket, rightBracket, index + 1, count);
        }
        sb.deleteCharAt(sb.length() - 1);

    }

    private static void optimizedDFS(String s, int start, int lastIndexRemoved, char openParen, char closeParen){
        int openCount = 0, closeCount = 0;
        for(int i = start; i < s.length(); i++){
            if(s.charAt(i) == openParen){
                openCount++;
            }
            if(s.charAt(i) == closeParen){
                closeCount++;
            }
            if(closeCount > openCount) {
                for (int j = lastIndexRemoved; j <= i; j++) {
                    if (s.charAt(j) == closeParen && (j == lastIndexRemoved || s.charAt(j - 1) != closeParen)) {
                        optimizedDFS(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, openParen,closeParen);
                    }
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(openParen == '('){
            optimizedDFS(reversed,0,0, ')', '(');
        }
        else {
            result.add(reversed);
        }
    }



    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(removeInvalidParentheses(s));
        System.out.println(removeInvalidParentheses("(a)())()"));
    }
}
