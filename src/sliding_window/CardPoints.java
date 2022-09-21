package sliding_window;
/**
 * Leetcode: 1423
 * */
public class CardPoints {

    private static int maxPoints(int[] cardPoints, int k) {
        int maxPoints = 0, sum = 0;
        for (int i : cardPoints) {
            sum += i;
        }
        if (k == cardPoints.length) {
            return sum;
        }
        int n = cardPoints.length, windowSum = 0;
        for (int i = 0; i < n - k - 1; i++) {
            windowSum += cardPoints[i];
        }

        for (int i = n - k - 1; i < n; i++) {
            windowSum += cardPoints[i];
            maxPoints = Math.max(maxPoints, sum - windowSum);
            windowSum -= cardPoints[i - (n - k - 1)];
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;
        System.out.println(maxPoints(cardPoints, k));
    }
}
