package bit_manipulation;
/* Moore's voting algorithm
* */
public class MajorityElement {

    private static  int findMajorityElement(int arr[]){
        int count =0;
        Integer candidate = null;
        for(int num : arr){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    public static void main(String[] args) {
        int arr[] = {3,2,2,1,1,2,2,15,2};
        Integer result = findMajorityElement(arr);
        System.out.println(result == null ? "Majority element is not present": "Majority element is present : " +result );
    }
}
