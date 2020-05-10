package recursion;

public class BalancedParanthesis {


    private static void printBalancedParanthesis(int idx, int n, int open, int close, char [] output){
        if(idx == 2*n ){
            output[idx] = '\0';
            System.out.println(output);
            return;
        }

        if(open < n){
            output[idx] = '{';
            printBalancedParanthesis(idx+1,n,open+1,close,output);
        }
        if(close < open){
            output[idx] = '}';
            printBalancedParanthesis(idx+1, n, open, close+1, output);
        }
    }

    private static void printAllBalancedParanthesis(String output, int open, int close, int n){
        if(open == n && close == n){
            System.out.println(output);
        }
        else {
            if(open < n){
                printAllBalancedParanthesis(output + "{", open+1, close,n);
            }
            if(close < open){
                printAllBalancedParanthesis(output + "}", open, close+1, n);
            }
        }
    }
    public static void main(String[] args) {
        char[] output = new char[100];
        //printBalancedParanthesis(0,3, 0,0,output);
        String str = "";
        printAllBalancedParanthesis(str,0,0,3);

    }
}
