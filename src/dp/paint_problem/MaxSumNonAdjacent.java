package dp.paint_problem;
/**
 * All paint house/fence problem are based on this problem, this is the parent problem and all problem will follow
 * same approach with some changes. It is a greedy problem
 * **/
public class MaxSumNonAdjacent {

    private static int findMaxNonAdjacentSum(int arr[]){
        int include = arr[0];
        int exclude = 0;

        for(int i = 1; i < arr.length;i++){
            int newInclude = exclude+arr[i];
            int newExclude = Math.max(include, exclude);

            include = newInclude;
            exclude = newExclude;
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int arr[] = {5,10,10,100, 5,6};
        System.out.println("max non adjacent sum is : "+ findMaxNonAdjacentSum(arr));

    }
}
