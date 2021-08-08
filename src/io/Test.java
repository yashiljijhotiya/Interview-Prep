package io;

public class Test {
    public static void main(String args[]) {
        System.out.println("Hello Yashil !!");
        System.out.println(solve("111110111111110000001110"));
        System.out.println(solve("011111011111111000000111111111111111111"));
        System.out.println(solve("0110011"));

    }

    private static int solve(String days) {
        int leftIndex=0, rightIndex=0, maxStreak = Integer.MIN_VALUE, streak = 0;
        while (rightIndex < days.length()) {
            if (days.charAt(rightIndex) == '1') {
                streak+=1;
            } else {
                leftIndex = rightIndex;
                maxStreak = Integer.max(maxStreak, streak + 1);
                streak = 0;
            }
            rightIndex++;
        }

        if (days.charAt(days.length() - 1) == '1') {
            streak = days.charAt(leftIndex) == '0' ?
                    streak + 1:
                    streak;
            maxStreak = Integer.max(maxStreak, streak);
        }


       // System.out.println(String.format("%d  -  %d", leftIndex, streak));

        return maxStreak;
    }

}
