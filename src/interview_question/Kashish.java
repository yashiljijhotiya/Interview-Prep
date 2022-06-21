package interview_question;

import java.util.HashSet;
import java.util.Set;

public class Kashish {

    private static int solution(int[] A, String [] D){
        int result = 0;
        int deductionCount = 12;

        for(int i = 0; i < A.length; i++) {
            result += A[i];
            if (A[i] > 100) {
                deductionCount--;
            }
        }
        Set<String> lookup = new HashSet<>();
        lookup.add("-01-");
        lookup.add("-02-");
        lookup.add("-03-");
        lookup.add("-04-");
        lookup.add("-05-");
        lookup.add("-06-");
        lookup.add("-07-");
        lookup.add("-08-");
        lookup.add("-09-");
        lookup.add("-10-");
        lookup.add("-11-");
        lookup.add("-12-");

        if(deductionCount > 0){
            deductionCount = deductionCount*5;
        }
        result = result - deductionCount;
        return result;
    }

    public static void main(String[] args) {

        int A[] = {100, 100,-10,-20,-30};
        //String s[] = {"a","b" };
       // System.out.println(solution(A));

    }
}
