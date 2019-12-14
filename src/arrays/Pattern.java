package arrays;
public class Pattern {

    private void printPattern(int n){
        int p = 1;
        for(int i = 1 ; i <= n; i++){
            for(int j = p ; j <= n; j++ ){
                System.out.print("#");
            }

            if(p <= n){
                System.out.println();
                p++;
            }
        }
    }

   private static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

        int ap = 0;
        int or = 0;
        for(int i = 0; i < apples.length; i++){

            if( s <= apples[i] + a  && apples[i] + a  <= t){
                ap++;
            }

        }
        for(int j = 0; j < oranges.length; j++){
            //if( s <= oranges[j] + b <= t){
             //   or++;
            //}
        }

        System.out.println(ap);
        System.out.println(or);


    }

    public static void main(String[] args) {
        Pattern s = new Pattern();
        s.printPattern(10);
    }
}
