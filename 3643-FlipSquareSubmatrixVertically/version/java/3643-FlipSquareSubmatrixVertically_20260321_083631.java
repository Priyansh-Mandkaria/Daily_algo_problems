// Last updated: 3/21/2026, 8:36:31 AM
1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        int sc = y, ec = y + k - 1, sr = x, er = x + k - 1;
4        for (int j = sc; j <= ec; j++) {
5            for (int i = 0; i < k / 2; i++) {
6                int tmp = grid[sr+i][j];
7                grid[sr+i][j] = grid[sr+k-i-1][j];
8                grid[sr+k-i-1][j] = tmp;
9            }
10        }
11        return grid;
12    }
13}