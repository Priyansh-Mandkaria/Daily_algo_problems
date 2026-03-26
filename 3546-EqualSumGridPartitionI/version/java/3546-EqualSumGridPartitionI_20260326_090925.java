// Last updated: 3/26/2026, 9:09:25 AM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4
5        long[] row_sum = new long[m], col_sum = new long[n];
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                int val = grid[i][j];
10                row_sum[i] += val; col_sum[j] += val;
11            }
12        }
13
14        long[] row_prefix = new long[m + 1];
15        for (int i = 0; i < m; i++) {
16            row_prefix[i + 1] = row_prefix[i] + row_sum[i];
17        }
18
19        long[] col_prefix = new long[n + 1];
20        for (int i = 0; i < n; i++) {
21            col_prefix[i + 1] = col_prefix[i] + col_sum[i];
22        }
23
24        long total_sum = row_prefix[m];
25
26        if (total_sum % 2 != 0) {
27            return false;
28        }
29
30        long target = total_sum / 2;
31
32        for (int i = 1; i < m; i++) {
33            if (row_prefix[i] == target) {
34                return true;
35            }
36        }
37
38        for (int i = 1; i < n; i++) {
39            if (col_prefix[i] == target) {
40                return true;
41            }
42        }
43        
44        return false;
45    }
46}