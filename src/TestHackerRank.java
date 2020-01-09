import java.util.TreeSet;

public class TestHackerRank {
    private  static  void stairPattern(int n){
        int c = 1;
//        int j = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j <= n-i){
                    System.out.print(" ");
                }
                else {
                    System.out.print("#");
                }
            }
            System.out.println();

        }



    }


    public static void main(String args[]){
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(11);
        ts.add(2);
        ts.add(19);
        System.out.println(ts);
        System.out.println(ts.floor(3));
        System.out.println(ts.ceiling(3));
        //stairPattern(3);
    }
}
