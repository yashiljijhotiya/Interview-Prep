package amazon;
import java.util.Stack;
//TC : O(n)
public class CelebrityProblem {

    private static boolean knows(int a, int b, int mat[][]){
       if(mat[a][b] == 1){
         return true;
       }
       return false;
    }

    private static int findCelebrity(int n, int mat[][]){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            stack.push(i);
        }
        while (stack.size() > 1){
            int a = stack.pop();
            int b = stack.pop();
            if(knows(a,b,mat)){
                stack.push(b);
            }
            else {
                stack.push(a);
            }
        }
        int c = stack.pop();
        for (int i = 0; i < n; i++){
            if( i != c && (knows(c,i,mat) || !knows(i,c,mat))){
                return -1;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        int mat[][] = {{},{},{},{}};

    }


}
