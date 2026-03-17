// Last updated: 3/17/2026, 11:08:19 AM
1class Solution {
2    public int largestSubmatrix(int[][] matrix) {
3        int m = matrix.length, n = matrix[0].length;
4        int maxArea = 0;
5        int[] h = new int[n];
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (matrix[i][j] == 1) h[j]++;
10                else h[j] = 0;
11            }
12            int[] sh = h.clone();
13            Arrays.sort(sh);
14            for (int j = n - 1; j >= 0; j--) {
15                if (sh[j] == 0) break;
16                maxArea = Math.max(maxArea, sh[j] * (n - j));
17            }
18        }
19        return maxArea;
20    }
21}