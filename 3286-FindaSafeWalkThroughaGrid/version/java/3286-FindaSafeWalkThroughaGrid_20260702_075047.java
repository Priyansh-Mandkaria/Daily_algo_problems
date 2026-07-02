// Last updated: 7/2/2026, 7:50:47 AM
1class Solution {
2    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
3        int n = grid.size();
4        int m = grid.get(0).size();
5        int[] dr = new int[] {0, 0, 1, -1};
6        int[] dc = new int[] {1, -1, 0, 0};
7        boolean[][][] visited = new boolean[n][m][health + 1];
8        Queue<int[]> bfs = new LinkedList<>(); 
9        bfs.add(new int[]{0, 0, health - grid.get(0).get(0)});
10        visited[0][0][health - grid.get(0).get(0)] = true;
11        while(!bfs.isEmpty()) {
12            int size = bfs.size();
13            while(size-- > 0) {
14                int[] currNode = bfs.poll();
15                int r = currNode[0];
16                int c = currNode[1];
17                int h = currNode[2];      
18                if(r == n-1 && c == m-1 && h > 0) {
19                    return true;
20                }       
21                for(int k = 0; k < 4; k++) {
22                    int nr = r + dr[k];
23                    int nc = c + dc[k];
24                    if(isValidMove(nr, nc, n, m)) {
25                        int nh = h - grid.get(nr).get(nc);
26                        if(nh >= 0 && visited[nr][nc][nh] == false) {
27                            visited[nr][nc][nh] = true;
28                            bfs.add(new int[]{nr, nc, nh});
29                        }
30                    }
31                }
32            }
33        }
34        return false;
35    }
36    private boolean isValidMove(int r, int c, int n, int m) {
37        return r >= 0 && c >= 0 && r < n && c < m;
38    }
39}