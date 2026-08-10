// Last updated: 8/10/2026, 9:26:34 AM
1class Solution {
2    public boolean winnerSquareGame(int n) {
3        boolean[] dp = new boolean[n + 1];
4        for (int i = 0; i <= n; i++) {
5            if (!dp[i]) {
6                for (int j = 1; i + j * j <= n; j++) {
7                    dp[i + j * j] = true;
8                }
9                if (dp[n]) {
10                    return true;
11                }
12            }
13        }
14        return false;
15    }
16}