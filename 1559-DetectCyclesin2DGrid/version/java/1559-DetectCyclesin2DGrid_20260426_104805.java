// Last updated: 4/26/2026, 10:48:05 AM
1class Solution {
2    int[] dx = {1,-1,0,0};
3    int[] dy = {0,0,1,-1};
4    public boolean containsCycle(char[][] grid) {
5        int n = grid.length;
6        int m = grid[0].length;
7        boolean[][] vis = new boolean[n][m];
8        for(int i = 0; i < n; i++){
9            for(int j = 0; j < m; j++){
10                if(!vis[i][j]){
11                    if(dfs(i, j, -1, -1, grid, vis)) return true;
12                }
13            }
14        }
15        return false;
16    }
17    public boolean dfs(int x, int y, int px, int py, char[][] grid, boolean[][] vis){
18        vis[x][y] = true;
19        int n = grid.length;
20        int m = grid[0].length;
21        for(int d = 0; d < 4; d++){
22            int nx = x + dx[d];
23            int ny = y + dy[d];
24            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
25            if(grid[nx][ny] != grid[x][y]) continue;
26            if(vis[nx][ny] && !(nx == px && ny == py)) return true;
27            if(!vis[nx][ny]){
28                if(dfs(nx, ny, x, y, grid, vis)) return true;
29            }
30        }
31        return false;
32    }
33}