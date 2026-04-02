// Last updated: 4/2/2026, 5:22:20 PM
1class Solution {
2
3    public int numIslands(char[][] grid) {
4        int m = grid.length;
5        int n = grid[0].length;
6        int c = 0;
7        for(int i = 0; i < m; i++){
8            for(int j = 0; j < n; j++){
9                if(grid[i][j] == '1'){
10                    dfs(grid, i, j);
11                    c++;
12                }
13            }
14        }
15        return c;
16    }
17    public void dfs(char[][] grid, int i, int j){
18        int m = grid.length;
19        int n = grid[0].length;
20        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0'){
21            return;
22        }
23        grid[i][j] = '0';
24        dfs(grid, i+1, j);
25        dfs(grid, i-1, j);
26        dfs(grid, i, j+1);
27        dfs(grid, i, j-1);
28    }
29}