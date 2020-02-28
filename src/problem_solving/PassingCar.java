package problem_solving;

public class PassingCar {

    private static int findTotalCarPassed(int car[]){
        int count = 0, result = 0;
        int n = car.length;

        while(n >= 1){
            if(car[n-1] == 1){
                count++;
            }
            else{
                result +=  count;
            }
            n--;
        }
        return result;
    }
    public static void main(String[] args) {
        int cars[] = {0,0,1,0,0};
        System.out.println( "total car passed : " + findTotalCarPassed(cars));
    }
}
