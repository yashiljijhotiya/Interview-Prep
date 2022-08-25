package dp.lcs;

public class LCSPractice {

    private static int LCS(String x, String y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return 1 + LCS(x, y, m, n);
        } else {
            return Math.max(LCS(x, y, m - 1, n), LCS(x, y, m, n - 1));
        }
    }

    private static int LPSubsequence(String x, int start, int end) {
        if (start > end) {
            return 0;
        }
        //for a single element is considered as palindrome
        if (start == end) {
            return 1;
        }
        if (x.charAt(start) == x.charAt(end)) {
            return 2 + LPSubsequence(x, start + 1, end - 1);
        }
        //skip one element from either side
        int c1 = LPSubsequence(x, start + 1, end);
        int c2 = LPSubsequence(x, start, end - 1);
        return Math.max(c1, c2);
    }

    private static int LPSubsequenceMemoize(String x, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (dp[start][end] == null) {
            if (x.charAt(start) == x.charAt(end)) {
                dp[start][end] = 2 + LPSubsequenceMemoize(x, start + 1, end - 1, dp);
            } else {
                int c1 = LPSubsequenceMemoize(x, start + 1, end, dp);
                int c2 = LPSubsequenceMemoize(x, start, end - 1, dp);
                dp[start][end] = Math.max(c1, c2);
            }
        }
        return dp[start][end];
    }

    private static int LPSubstring(String x, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (x.charAt(start) == x.charAt(end)) {
            int remainingLen = end - start - 1;
            if (remainingLen == LPSubstring(x, start + 1, end - 1)) {
                return 2 + remainingLen;
            }
        }
        int c1 = LPSubstring(x, start + 1, end);
        int c2 = LPSubstring(x, start, end - 1);
        return Math.max(c1, c2);
    }

    private static int LPSubstringMemoize(String x, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (dp[start][end] == null) {
            if (x.charAt(start) == x.charAt(end)) {
                int remainingLen = end - start - 1;
                if (remainingLen == LPSubstringMemoize(x, start + 1, end - 1, dp)) {
                    dp[start][end] = 2 + remainingLen;
                }
                return dp[start][end];
            }
            int c1 = LPSubstringMemoize(x, start + 1, end, dp);
            int c2 = LPSubstringMemoize(x, start, end - 1, dp);
            dp[start][end] = Math.max(c1, c2);
        }
        return dp[start][end];
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        System.out.println(LCS(x, y, x.length(), y.length()));

    }
}
