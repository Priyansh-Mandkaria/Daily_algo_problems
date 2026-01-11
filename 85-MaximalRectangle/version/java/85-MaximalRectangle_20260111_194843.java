// Last updated: 1/11/2026, 7:48:43 PM
1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
4            return 0;
5
6        int M = matrix.length;
7        int N = matrix[0].length;
8
9        int[][] mat = new int[M][N];
10
11        // convert char to int
12        for (int i = 0; i < M; i++) {
13            for (int j = 0; j < N; j++) {
14                mat[i][j] = matrix[i][j] - '0';
15            }
16        }
17
18        // row-wise prefix widths
19        for (int i = 0; i < M; i++) {
20            for (int j = 1; j < N; j++) {
21                if (mat[i][j] == 1) {
22                    mat[i][j] += mat[i][j - 1];
23                }
24            }
25        }
26
27        int Ans = 0;
28
29        // fix each column
30        for (int j = 0; j < N; j++) {
31            for (int i = 0; i < M; i++) {
32                int width = mat[i][j];
33                if (width == 0) continue;
34
35                // expand downward
36                int currWidth = width;
37                for (int k = i; k < M && mat[k][j] > 0; k++) {
38                    currWidth = Math.min(currWidth, mat[k][j]);
39                    int height = k - i + 1;
40                    Ans = Math.max(Ans, currWidth * height);
41                }
42
43                // expand upward
44                currWidth = width;
45                for (int k = i; k >= 0 && mat[k][j] > 0; k--) {
46                    currWidth = Math.min(currWidth, mat[k][j]);
47                    int height = i - k + 1;
48                    Ans = Math.max(Ans, currWidth * height);
49                }
50            }
51        }
52
53        return Ans;
54    }
55}