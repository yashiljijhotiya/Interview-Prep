package interview_question;

import java.util.Arrays;
import java.util.List;

public class Genpact {

    private static  int getMinVal(List<Integer> itemCount, int target){
        int result = 0;
        int sum = 0;
        int len = itemCount.size();
        for(int i = 0; i < len; i++){
            if(sum < target){
                sum += itemCount.get(i);
                if(i == len-1){
                    result = target - sum;
                    break;
                }
            }
            else{
                result = sum - target;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(3,1,2,4);
        System.out.println(getMinVal(num, 100));
    }
}
