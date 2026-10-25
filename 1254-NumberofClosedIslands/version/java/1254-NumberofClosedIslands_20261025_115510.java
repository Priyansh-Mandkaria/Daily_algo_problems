// Last updated: 10/25/2026, 11:55:10 AM
1class Solution {
2    public int closedIsland(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        for (int i = 0; i < m; i++) {
5            if (grid[i][0] == 0) dfs(grid, i, 0);
6            if (grid[i][n - 1] == 0) dfs(grid, i, n - 1);
7        }
8        for (int j = 0; j < n; j++) {
9            if (grid[0][j] == 0) dfs(grid, 0, j);
10            if (grid[m - 1][j] == 0) dfs(grid, m - 1, j);
11        }
12        int ans = 0;
13        for (int i = 1; i < m - 1; i++) {
14            for (int j = 1; j < n - 1; j++) {
15                if (grid[i][j] == 0) {
16                    ans++;
17                    dfs(grid, i, j);
18                }
19            }
20        }
21        return ans;
22    }
23    private void dfs(int[][] grid, int i, int j) {
24        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1) return;
25        grid[i][j] = 1;
26        dfs(grid, i + 1, j);
27        dfs(grid, i - 1, j);
28        dfs(grid, i, j + 1);
29        dfs(grid, i, j - 1);
30    }
31}