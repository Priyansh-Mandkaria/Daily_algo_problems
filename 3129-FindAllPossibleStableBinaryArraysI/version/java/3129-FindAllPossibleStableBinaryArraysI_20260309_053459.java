// Last updated: 3/9/2026, 5:34:59 AM
1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3        final int mod = 1_000_000_007;
4        int L = limit + 1;
5
6        int[][] dp0 = new int[zero + 1][one + 1]; // i 0s + j 1s ending with 0
7        int[][] dp1 = new int[zero + 1][one + 1]; // i 0s + j 1s ending with 1
8
9        // Base cases: only zeros or only ones => only one string if len <= min(limit, zero/one)
10        for (int i = 1; i <= Math.min(zero, limit); ++i) dp0[i][0] = 1;
11        for (int j = 1; j <= Math.min(one, limit); ++j) dp1[0][j] = 1;
12
13        // DP iterations
14        for (int i = 1; i <= zero; ++i) {
15            for (int j = 1; j <= one; ++j) {
16                dp0[i][j] = (dp0[i - 1][j] + dp1[i - 1][j] - (i >= L ? dp1[i - L][j] : 0)) % mod;
17                dp1[i][j] = (dp1[i][j - 1] + dp0[i][j - 1] - (j >= L ? dp0[i][j - L] : 0)) % mod;
18
19                // Fix negatives
20                dp0[i][j] = (dp0[i][j] + mod) % mod;
21                dp1[i][j] = (dp1[i][j] + mod) % mod;
22            }
23        }
24
25        return (dp0[zero][one] + dp1[zero][one]) % mod;
26    }
27}