package problem_solving;

public class FrogJump {

    private static int findSteps(int arr[], int x){
        int steps = x;
        boolean isVisited[] = new  boolean[x+1];
        for(int i =0; i < arr.length; i++){
            if(!isVisited[arr[i]]){
                isVisited[arr[i]] = true;
                steps--;
            }
            if(steps == 0){
                return i;
            }
        }
      return -1;
    }

    public static void main(String[] args) {
     int arr[] = {1,3,1,4,2,3,4,5};
        System.out.println("min no. steps to cover dist is " + findSteps(arr, 5));
    }
}
