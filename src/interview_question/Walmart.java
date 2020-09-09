package interview_question;

public class Walmart {

    private static  int findCoPrime(int arr[]){
        int max = Integer.MAX_VALUE;
        int coPrime = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        for(int i = 2; i < max; i++){
            int j = 0;
            while (j < arr.length){
                int gcd = gcd(arr[j],i);
                if(gcd != 1){
                    break;
                }
                j++;
                if(j == arr.length){
                    coPrime = i;
                }
            }
            if(coPrime != 0){
                return coPrime;
            }
        }
        return coPrime;
    }

    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int arr[] = {5,7,25};
        System.out.println(findCoPrime(arr));
    }
}
