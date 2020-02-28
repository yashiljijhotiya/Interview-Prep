package arrays;

public class FindAllMissingNumber {
    private static void printAllMissingNum(int num[]){
        if(num == null || num.length == 0){
            System.out.println("there is no value present in array");
            return;
        }
        for(int i = 0; i < num.length; i++){
            int pos = Math.abs(num[i])- 1;
            if(num[pos] > 0){
                num[pos] *= -1;
            }
        }
        for(int i = 0; i < num.length; i++){
            if(num[i] > 0){
                System.out.println(i+1);
            }
        }
    }
    public static void main(String[] args) {
        int num[] = {4,3,2,7,8,2,3,1};
        printAllMissingNum(num);
    }
}
