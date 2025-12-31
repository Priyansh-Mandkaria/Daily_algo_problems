// Last updated: 12/31/2025, 1:14:12 PM
1class Solution {
2    public int latestDayToCross(int row, int col, int[][] cells) {
3        DSU dsu = new DSU(row * col + 2);
4        int[][] grid = new int[row][col];
5        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
6
7        for (int i = 0; i < row * col; i++) {
8            int r = cells[i][0] - 1;
9            int c = cells[i][1] - 1;
10            grid[r][c] = 1;
11
12            int id1 = r * col + c + 1;
13
14            for (int[] d : dirs) {
15                int nr = r + d[0];
16                int nc = c + d[1];
17                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
18                    dsu.union(id1, nr * col + nc + 1);
19                }
20            }
21
22            if (c == 0)
23                dsu.union(0, id1);
24            if (c == col - 1)
25                dsu.union(row * col + 1, id1);
26
27            if (dsu.find(0) == dsu.find(row * col + 1))
28                return i;
29        }
30
31        return -1;
32    }
33}
34
35class DSU {
36    int[] root, size;
37
38    public DSU(int n) {
39        root = new int[n];
40        size = new int[n];
41        for (int i = 0; i < n; i++)
42            root[i] = i;
43        Arrays.fill(size, 1);
44    }
45
46    public int find(int x) {
47        if (root[x] != x)
48            root[x] = find(root[x]);
49        return root[x];
50    }
51
52    public void union(int x, int y) {
53        int rx = find(x);
54        int ry = find(y);
55
56        if (rx == ry)
57            return;
58
59        if (size[rx] > size[ry]) {
60            int tmp = rx;
61            rx = ry;
62            ry = tmp;
63        }
64
65        root[rx] = ry;
66        size[ry] += size[rx];
67    }
68}
69