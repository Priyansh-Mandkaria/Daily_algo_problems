// Last updated: 12/28/2025, 3:23:22 PM
// Staircase method same as motive - prince another type of same question
1class Solution {
2    public int countNegatives(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        int i = m - 1, j = 0;
5        int res = 0;
6        while (i >= 0 && j < n) {
7            if (grid[i][j] < 0) {
8                res += n - j;
9                i--;
10            } else
11                j++;
12        }
13        return res;
14    }
15}
16