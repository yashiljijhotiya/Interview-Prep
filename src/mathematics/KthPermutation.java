package mathematics;

public class KthPermutation {

    private static int findPermutation(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return  n * findPermutation(n-1);
    }

    private static void findKthPermutation(int n, int k){

    }

  public static void main(String[] args) {

  }
}
