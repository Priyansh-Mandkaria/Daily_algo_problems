// Last updated: 3/24/2026, 12:59:09 AM
1class Solution {
2    public int maxProductPath(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        long MOD = 1000000007;
5
6        long[][] mx = new long[m][n];
7        long[][] mn = new long[m][n];
8
9        mx[0][0] = mn[0][0] = grid[0][0];
10
11        // first row
12        for (int j = 1; j < n; j++) {
13            mx[0][j] = mn[0][j] = mx[0][j - 1] * grid[0][j];
14        }
15
16        // first column
17        for (int i = 1; i < m; i++) {
18            mx[i][0] = mn[i][0] = mx[i - 1][0] * grid[i][0];
19        }
20
21        for (int i = 1; i < m; i++) {
22            for (int j = 1; j < n; j++) {
23                long x = grid[i][j];
24
25                long a = mx[i - 1][j] * x;
26                long b = mn[i - 1][j] * x;
27                long c = mx[i][j - 1] * x;
28                long d = mn[i][j - 1] * x;
29
30                mx[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
31                mn[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
32            }
33        }
34
35        long ans = mx[m - 1][n - 1];
36        if (ans < 0) return -1;
37        return (int)(ans % MOD);
38    }
39}