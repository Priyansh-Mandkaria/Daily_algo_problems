// Last updated: 3/4/2026, 6:03:23 PM
1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length, n = mat[0].length;
4        int[] row = new int[m];
5        int[] col = new int[n];
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (mat[i][j] == 1) {
9                    row[i]++;
10                    col[j]++;
11                }
12            }
13        }
14        int ans = 0;
15        for (int i = 0; i < m; i++) {
16            for (int j = 0; j < n; j++) {
17                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
18                    ans++;
19                }
20            }
21        }
22        return ans;
23    }
24}