package interview_question;

public class AliceCandy {

    private static int findMinCandy(int candy[], int n) {

        if(n == 0){
            return 0;
        }
        //It will store the no. of candies buy by Alice
        int minCandy = 0;

        /*these two given left[] and right[] arrays will store the number of candies for each student
        * Here I break the problem into two sub problems i.e. two calculate the no. candy from left to right
        * according to ranking in left[] and vice versa for right[].
        * */
        int left[] = new int[n];
        int right[] = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (candy[i - 1] < candy[i]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (candy[i] < candy[i - 1]) {
                right[i - 1] = right[i] + 1;
            }
        }

        //this loop will use to take the max of both left neighbour and right neighbour max for every students.
        for (int i = 0; i < n; i++) {
            minCandy += Math.max(left[i], right[i]);
        }

        return minCandy;
    }

    public static void main(String[] args) {
        int candy[] = {4, 6, 4, 5, 6, 2};
        System.out.println("Minimum number of candies buy by Alice are :" + findMinCandy(candy,candy.length));
    }
}
