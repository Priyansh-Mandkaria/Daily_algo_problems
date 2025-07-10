// Last updated: 7/10/2025, 8:54:57 AM
import java.util.*;

class Solution {

    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int minDays(int[][] grid) {
        if (isDisconnected(grid)) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isDisconnected(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        
        return 2;
    }
    
    private boolean isDisconnected(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean foundIsland = false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (foundIsland) return true;  // More than one island found
                    dfs(grid, visited, i, j);
                    foundIsland = true;
                }
            }
        }
        
        return !foundIsland;  // If no island is found, grid is disconnected
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        visited[i][j] = true;
        
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
                dfs(grid, visited, x, y);
            }
        }
    }
}
