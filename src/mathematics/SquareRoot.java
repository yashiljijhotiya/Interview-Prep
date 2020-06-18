package mathematics;

/*
* The idea is to search the square root within the range 1 to x.
We check :
if(midmid)>x: it means the square root lies between 1 to mid,thus we reduce the search window between 1 to mid.
if(midmid<=x): it means that mid can be a probable answer and we store it in ans and again search if we have another answer greater to this mid which can be the closest answer.
* */

public class SquareRoot {
    private static int findSqrt(int num){
        if(num == 0 || num == 1){
            return num;
        }
        int result = 1, l = 1, r = num;
        while (l <= r){
            int mid = (l + r)/2;
            if(mid <= num/mid){
                l = mid + 1;
                result = mid;
            }
            else {
                r = mid - 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(findSqrt(99));
    }
}
