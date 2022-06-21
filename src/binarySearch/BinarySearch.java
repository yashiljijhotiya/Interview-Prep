package binarySearch;
//TC : log(n)
public class    BinarySearch {

    private static int binarySearchIterative(int arr[], int candidate){
        int startIndex = 0, endIndex = arr.length -1;
        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if(arr[midIndex] == candidate){
                return midIndex;
            }
            else if(arr[midIndex] > candidate){
                 endIndex = midIndex - 1;
            }
            else
            {
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int arr[], int candidate){
        return binarySearchRecursiveUtil(arr,candidate, 0, arr.length -1);

    }

    private static int binarySearchRecursiveUtil(int arr[], int candidate, int startIndex, int endIndex){
        if(startIndex > endIndex){
            return -1;
        }
        int midIndex = startIndex + (endIndex - startIndex)/2;
        if(arr[midIndex] == candidate){
            return midIndex;
        }
        return  arr[midIndex] > candidate ? binarySearchRecursiveUtil(arr,candidate,startIndex, midIndex -1) :
                binarySearchRecursiveUtil(arr,candidate, midIndex +1, endIndex);
    }

    public static void main(String[] args) {
        int arr[] = {2,4,7,11,19,21,66,89,144,188};
        System.out.println("Iterative Binary Search!!");
        System.out.println(binarySearchIterative(arr,11));//3
        System.out.println(binarySearchIterative(arr,111));//-1
        System.out.println(binarySearchIterative(arr,188));//9
        System.out.println(binarySearchIterative(arr,2));//0

        System.out.println("Recursive Binary Search!!");
        System.out.println(binarySearchRecursive(arr,11));
        System.out.println(binarySearchRecursive(arr,111));
        System.out.println(binarySearchRecursive(arr,188));
        System.out.println(binarySearchRecursive(arr,2));

    }
}
