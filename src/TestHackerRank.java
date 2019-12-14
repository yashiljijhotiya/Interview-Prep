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
        stairPattern(3);
    }
}
