// Last updated: 9/6/2026, 8:05:11 AM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length(), n = t.length();
4        if (m < n) {
5            return 0;
6        }
7        int[][] dp = new int[m + 1][n + 1];
8        for (int i = 0; i <= m; i++) {
9            dp[i][n] = 1;
10        }
11        for (int i = m - 1; i >= 0; i--) {
12            char sChar = s.charAt(i);
13            for (int j = n - 1; j >= 0; j--) {
14                char tChar = t.charAt(j);
15                if (sChar == tChar) {
16                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
17                } else {
18                    dp[i][j] = dp[i + 1][j];
19                }
20            }
21        }
22        return dp[0][0];
23    }
24}