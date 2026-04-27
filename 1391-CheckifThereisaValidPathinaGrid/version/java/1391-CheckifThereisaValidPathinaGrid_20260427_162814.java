// Last updated: 4/27/2026, 4:28:14 PM
1class Solution {
2    private static final int[][] TRANS = {
3        {-1, 1, -1, 3},
4        {0, -1, 2, -1},
5        {3, 2, -1, -1},
6        {1, -1, -1, 2},
7        {-1, 0, 3, -1},
8        {-1, -1, 1, 0}
9    };
10    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
11    private static final int[][] START = {{1, 3}, {0, 2}, {2, 3},
12                                          {1, 2}, {0, 3}, {0, 1}};
13
14    public boolean hasValidPath(int[][] grid) {
15        if (grid[0][0] == 5) return false;
16        if (grid[grid.length - 1][grid[0].length - 1] == 4) return false;
17
18        int m = grid.length, n = grid[0].length;
19        if (m == 1 && n == 1) return true;
20
21        int[] s = START[grid[0][0] - 1];
22        return check(grid, s[0]) || check(grid, s[1]);
23    }
24
25    private boolean check(int[][] grid, int di) {
26        if (di == -1) return false;
27        int m = grid.length, n = grid[0].length;
28        int r = DIRS[di][0];
29        int c = DIRS[di][1];
30
31        while (r >= 0 && r < m && c >= 0 && c < n) {
32            di = TRANS[grid[r][c] - 1][di];
33            if (di == -1 || r == 0 && c == 0) return false;
34            if (r == m - 1 && c == n - 1) return true;
35
36            r += DIRS[di][0];
37            c += DIRS[di][1];
38        }
39        return false;
40    }
41}