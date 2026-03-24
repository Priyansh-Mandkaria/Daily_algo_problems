// Last updated: 3/24/2026, 6:35:46 AM
1class Solution {
2        public int[][] constructProductMatrix(int[][] grid) {
3        int n = grid.length, m = grid[0].length, A[][] = new int[n][m];
4        long pre = 1, suf = 1, mod = 12345;
5        for (int i = 0; i < n; i++) {
6            if (i <= n - i - 1) {
7                Arrays.fill(A[i], 1);
8                Arrays.fill(A[n - i - 1], 1);
9            }
10            for (int j = 0; j < m; j++) {
11                A[i][j] = (int)(pre * A[i][j] % mod);
12                A[n - i - 1][m - j - 1] = (int)(suf * A[n - i - 1][m - j - 1] % mod);
13                pre = pre * grid[i][j] % mod;
14                suf = suf * grid[n - i - 1][m - j - 1] % mod;
15            }
16        }
17        return A;
18    }
19}