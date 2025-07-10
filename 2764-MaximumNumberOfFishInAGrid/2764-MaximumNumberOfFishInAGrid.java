// Last updated: 7/10/2025, 8:52:11 AM
class Solution {
    public int findMaxFish(int[][] grid) {
         int res = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] > 0)
                    res = Math.max(res, dfs(i, j, grid));
        return res;
    }
    private int dfs(int r, int c, int[][] grid){
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0)
            return 0;
        int res = grid[r][c];
        grid[r][c] = 0;
        return res + dfs(r + 1, c, grid) + dfs(r - 1, c, grid) + dfs(r, c + 1, grid) + dfs(r, c -  1, grid);
    }
}