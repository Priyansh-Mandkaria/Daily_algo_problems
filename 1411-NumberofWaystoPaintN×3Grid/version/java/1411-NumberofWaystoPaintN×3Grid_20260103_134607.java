// Last updated: 1/3/2026, 1:46:07 PM
1class Solution {
2    public int numOfWays(int n) {
3        final int MOD = 1_000_000_007;
4        long A = 6, B = 6;
5        for (int i = 2; i <= n; i++) {
6            long newA = (2 * A + 2 * B) % MOD;
7            long newB = (2 * A + 3 * B) % MOD;
8            A = newA;
9            B = newB;
10        }
11        return (int) ((A + B) % MOD);
12    }
13}