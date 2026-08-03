// Last updated: 8/3/2026, 5:26:48 PM
1class Solution {
2    static final String[] s = { "Bob", "Tie", "Alice" };
3    public String stoneGameIII(int[] A) {
4        int n = A.length;
5        int[] dp = { 0, 0, 0, 0 };
6        for (int i = n - 1; i >= 0; i--) {
7            dp[i & 3] = Integer.MIN_VALUE;
8            int sum = 0;
9            for (int j = 1; j <= 3 && i + j <= n; j++) {
10                sum += A[i + j - 1];
11                dp[i & 3] = Math.max(dp[i & 3], sum - dp[(i + j) & 3]);
12            }
13        }
14        return s[Integer.signum(dp[0]) + 1];
15    }
16}