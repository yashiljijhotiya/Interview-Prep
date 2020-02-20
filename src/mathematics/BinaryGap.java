package mathematics;

public class BinaryGap {

    private static void findMaxBinaryGap(int n){
//        int binaryArr[] = new int[32];
//        int count = 0;
//        int result = Integer.MIN_VALUE;
//        if(n == 0){
//            return 0;
//        }
//        int i = 0;
//        while(n >= 1){
//            binaryArr[i] = n%2;
//            i++;
//            n = n/2;
//        }
//        int z = 0;
//        for(int j = i-1; j >= 0; j--){
//           // System.out.println(binaryArr[j]);
//            if(binaryArr[j] == 0 && z == 0){
//                count++;
//                z = -99;
//            }
//            if(binaryArr[j] == 1 && z != -99 ){
//                result = Math.max(count,result);
//                z = 0;
//                count = 0;
//            }
//        }

        //return result;

        System.out.println(Integer.numberOfTrailingZeros(n));
    }
    public static void main(String[] args) {
        findMaxBinaryGap(16

        );
    }
}
