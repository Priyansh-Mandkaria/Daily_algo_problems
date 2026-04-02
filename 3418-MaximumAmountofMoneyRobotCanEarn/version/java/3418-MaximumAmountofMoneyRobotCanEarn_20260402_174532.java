// Last updated: 4/2/2026, 5:45:32 PM
1class Solution {
2    public int maximumAmount(int[][] coins) {
3        int n = coins.length;
4        int m = coins[0].length;
5        int[][][] dp = new int[n][m][3];
6        for (int[][] row : dp) {
7            for (int[] col : row) {
8                java.util.Arrays.fill(col, (int)-1e9);
9            }
10        }
11        dp[0][0][1] = 0;
12        dp[0][0][2] = 0;
13        dp[0][0][0] = coins[0][0];
14        for (int i = 0; i < n; i++)
15            for (int j = 0; j < m; j++)
16                for (int k = 0; k < 3; k++) {
17                    if (i > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k] + coins[i][j]);
18                    if (i > 0 && k > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1]);
19                    if (j > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k] + coins[i][j]);
20                    if (j > 0 && k > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1]);
21                }
22        return Math.max(dp[n - 1][m - 1][0], Math.max(dp[n - 1][m - 1][1], dp[n - 1][m - 1][2]));
23    }
24}