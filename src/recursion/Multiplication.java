package recursion;

/*Multiply two no. without using * operator
*
* */
public class Multiplication {

    private static int findProduct(int a, int b){
        if(b == 0){
            return 0;
        }
       else if(b == 1){
            return a;
        }
       else if(b > 0){
           return a + findProduct(a, b-1);
        }
       else {
           return - findProduct(a,-b);
        }

    }
    public static void main(String[] args) {
    }
}
