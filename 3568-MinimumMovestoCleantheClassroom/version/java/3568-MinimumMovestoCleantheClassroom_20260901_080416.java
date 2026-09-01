// Last updated: 9/1/2026, 8:04:16 AM
1class Solution {
2    public int minMoves(String[] classroom, int energy) {
3        int m = classroom.length;
4        int n = classroom[0].length();
5        int[][] id = new int[m][n];
6        for (int r = 0; r < m; r++) {
7            java.util.Arrays.fill(id[r], -1);
8        }
9        int k = 0;
10        int sr = 0, sc = 0;
11        for (int r = 0; r < m; r++) {
12            for (int c = 0; c < n; c++) {
13                if (classroom[r].charAt(c) == 'S') {
14                    sr = r;
15                    sc = c;
16                } else if (classroom[r].charAt(c) == 'L') {
17                    id[r][c] = k++;
18                }
19            }
20        }
21        if (k == 0) return 0;
22        int totalMask = (1 << k) - 1;
23        int[][][] best = new int[m][n][1 << k];
24        for (int r = 0; r < m; r++) {
25            for (int c = 0; c < n; c++) {
26                java.util.Arrays.fill(best[r][c], -1);
27            }
28        }
29        class State {
30            int r, c, mask, e, moves;
31            State(int r, int c, int mask, int e, int moves) {
32                this.r = r;
33                this.c = c;
34                this.mask = mask;
35                this.e = e;
36                this.moves = moves;
37            }
38        }
39        java.util.ArrayDeque<State> queue = new java.util.ArrayDeque<>();
40        best[sr][sc][0] = energy;
41        queue.offer(new State(sr, sc, 0, energy, 0));
42        int[] dr = {-1, 1, 0, 0};
43        int[] dc = {0, 0, -1, 1};
44        while (!queue.isEmpty()) {
45            State cur = queue.poll();
46            for (int d = 0; d < 4; d++) {
47                int nr = cur.r + dr[d];
48                int nc = cur.c + dc[d];
49                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
50                    continue;
51                if (classroom[nr].charAt(nc) == 'X')
52                    continue;
53                int ne = cur.e - 1;
54                if (ne < 0)
55                    continue;
56                int nmask = cur.mask;
57                if (classroom[nr].charAt(nc) == 'R') {
58                    ne = energy;
59                }
60                if (classroom[nr].charAt(nc) == 'L') {
61                    nmask |= (1 << id[nr][nc]);
62                }
63                if (nmask == totalMask) {
64                    return cur.moves + 1;
65                }
66                if (ne <= best[nr][nc][nmask])
67                    continue;
68                best[nr][nc][nmask] = ne;
69                queue.offer(new State(nr, nc, nmask, ne, cur.moves + 1));
70            }
71        }
72        return -1;
73    }
74}