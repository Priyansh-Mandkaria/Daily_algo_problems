// Last updated: 7/10/2025, 8:56:35 AM
public class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int regions = 0;
        boolean[][] visited = new boolean[n * 3][n * 3];       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                int r = i * 3;
                int c = j * 3;
                if (ch == '/') {
                    visited[r][c + 2] = true;
                    visited[r + 1][c + 1] = true;
                    visited[r + 2][c] = true;
                } else if (ch == '\\') {
                    visited[r][c] = true;
                    visited[r + 1][c + 1] = true;
                    visited[r + 2][c + 2] = true;
                }
            }
        }
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (!visited[i][j]) {
                    regions++;
                    dfs(visited, i, j);
                }
            }
        }  
        return regions;
    }  
    private void dfs(boolean[][] visited, int i, int j) {
        int n = visited.length;       
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j]) {
            return;
        }       
        visited[i][j] = true;      
        dfs(visited, i + 1, j);
        dfs(visited, i - 1, j);
        dfs(visited, i, j + 1);
        dfs(visited, i, j - 1);
    }
}
