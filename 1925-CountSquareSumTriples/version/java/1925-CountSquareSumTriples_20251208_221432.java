// Last updated: 12/8/2025, 10:14:32 PM
1class Solution {
2    public int countTriples(int n) {
3        int res = 0;
4        for (int u = 2; u * u <= n; u++) {
5            for (int v = 1; v < u; v++) {
6                if (((u - v) & 1) == 0 || gcd(u, v) != 1) continue;
7                int c = u * u + v * v;
8                if (c > n) continue;
9                res += (n / c) << 1;
10            }
11        }
12        return res;
13    }
14    int gcd(int x, int y) {
15        return y == 0 ? x : gcd(y, x % y);
16    }
17}
18