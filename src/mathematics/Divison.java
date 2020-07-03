package mathematics;
/* In the given problem x is dividend, y is divisor and we need to find out the question
*  TC : O(log(n))
*  SC : log(n)
* */
public class Divison {

    private static int findQuestion(int x, int y){
        if(y == 0){
            return -1;
        }
        if(x < y){
            return 0;
        }
        else if(x == y){
            return 1;
        }
        else if(y == 1){
            return x;
        }
        int q = 1;
        int val = y;
        while (val < x){
            val <<= 1;
            q <<= 1;
        }
        if(val > x){
            val >>= 1;
            q >>= 1;
            return  q + findQuestion(x-val,y);
        }
        return q;
    }
  public static void main(String[] args) {
    System.out.println("7/2 == " + findQuestion(7,2));
  }
}
