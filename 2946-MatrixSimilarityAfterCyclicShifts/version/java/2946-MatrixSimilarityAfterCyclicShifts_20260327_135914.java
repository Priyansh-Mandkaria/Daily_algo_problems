// Last updated: 3/27/2026, 1:59:14 PM
1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length;
4        int n = mat[0].length;
5        k %= n;
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8                if (i % 2 == 0) {
9                    if (mat[i][j] != mat[i][(j + k) % n]) {
10                        return false;
11                    }
12                } else {
13                    if (mat[i][j] != mat[i][(j - k + n) % n]) {
14                        return false;
15                    }
16                }
17            }
18        }
19        return true;
20    }
21}