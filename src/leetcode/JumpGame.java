package leetcode;

public class JumpGame {

    private static int minJumpToReachEnd(int steps[]){
        int result = 1;
        int len = steps.length;
        if(steps == null || len == 0 || len < 2){
            return 0;
        }

        int maxPos = steps[0];
        int maxSteps = steps[0];

        for(int i = 1; i < len; i++){

            if(maxSteps < i){
                ++result;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos,steps[i]+i);
        }

        return result;
    }

    public static void main(String[] args) {
        int steps [] = {2,3,1,1,4};
        minJumpToReachEnd(steps);
    }
}
