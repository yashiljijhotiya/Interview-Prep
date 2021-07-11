package bit_manipulation;

public class JosephusAlgorithm {

    private  static int print(int num ){
        if(num == 0){
            return 0;
        }
        return 1+ print(num/10);
    }
    public static void main(String[] args) {
        System.out.println(print(9967));
    }
}
