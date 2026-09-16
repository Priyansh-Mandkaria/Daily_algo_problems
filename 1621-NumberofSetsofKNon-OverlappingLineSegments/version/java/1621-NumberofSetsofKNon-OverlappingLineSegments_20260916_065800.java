// Last updated: 9/16/2026, 6:58:00 AM
1class Solution {
2    private static final long MOD = 1000000007L;
3    private long quickPow(long a, long e) {
4        long result = 1;
5        while (e > 0) {
6            if ((e & 1) != 0)
7                result = (result * a) % MOD;
8            a = (a * a) % MOD;
9            e >>= 1;
10        }
11        return result;
12    }
13    public int numberOfSets(int n, int k) {
14        int m = 2 * k;
15        long numerator = 1;
16        long denominator = 1;
17        for (int i = 1; i <= m; i++) {
18            numerator =
19                (numerator * (n + k - i)) % MOD;
20            denominator =
21                (denominator * i) % MOD;
22        }
23        return (int) (
24            (numerator *
25             quickPow(denominator, MOD - 2))
26            % MOD
27        );
28    }
29}