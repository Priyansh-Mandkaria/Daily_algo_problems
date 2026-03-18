// Last updated: 3/18/2026, 4:46:34 PM
1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int ans = 0;
5        int[][] px = new int[m + 1][n + 1];
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                px[i+1][j+1] = grid[i][j] + px[i][j+1] + px[i+1][j] - px[i][j];
9                if (px[i+1][j+1] <= k) ans++;
10            }
11        }
12        return ans;
13    }
14}