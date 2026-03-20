// Last updated: 3/20/2026, 8:58:45 AM
1class Solution {
2    public int[][] minAbsDiff(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int[][] ans = new int[m - k + 1][n - k + 1];
5
6        for (int i = 0; i <= m - k; i++) {
7            for (int j = 0; j <= n - k; j++) {
8                List<Integer> v = new ArrayList<>();
9                for (int x = i; x < i + k; x++)
10                    for (int y = j; y < j + k; y++)
11                        v.add(grid[x][y]);
12
13                Collections.sort(v);
14                int mn = Integer.MAX_VALUE;
15                int prev = v.get(0);
16                for (int p = 1; p < v.size(); p++) {
17                    if (v.get(p) != prev)
18                        mn = Math.min(mn, v.get(p) - prev);
19                    prev = v.get(p);
20                }
21                ans[i][j] = (mn == Integer.MAX_VALUE) ? 0 : mn;
22            }
23        }
24        return ans;
25    }
26}