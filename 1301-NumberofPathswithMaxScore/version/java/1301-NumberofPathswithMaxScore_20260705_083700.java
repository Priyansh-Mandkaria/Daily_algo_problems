// Last updated: 7/5/2026, 8:37:00 AM
1class Solution {
2    static final int MOD = 1_000_000_007;
3    public int[] pathsWithMaxScore(List<String> board) {
4        int n = board.size();
5        int[][] score = new int[n][n];
6        int[][] ways = new int[n][n];
7        for(int[] row : score) {
8            Arrays.fill(row, -1);
9        }
10        score[n-1][n-1] = 0;
11        ways[n-1][n-1] = 1;
12        int dir[][] = {{1, 0}, {0, 1}, {1, 1}};
13        for(int i=n-1; i>=0; i--) {
14            for(int j=n-1; j>=0; j--) {
15                if(board.get(i).charAt(j) == 'X') continue;
16                if(i == n-1 && j == n-1) continue;
17                int best = -1;
18                for(int[] d: dir) {
19                    int r = i + d[0];
20                    int c = j + d[1];
21                    if(r < n && c < n) {
22                        best = Math.max(best, score[r][c]);
23                    }
24                }
25                if(best == -1) continue;
26                int cnt = 0;
27                for (int[] d : dir) {
28                    int r = i + d[0];
29                    int c = j + d[1];
30                    if (r < n && c < n && score[r][c] == best)
31                        cnt = (cnt + ways[r][c]) % MOD;
32                }
33                char ch = board.get(i).charAt(j);
34                int val = (ch == 'E' || ch == 'S') ? 0 : ch - '0';
35                score[i][j] = best + val;
36                ways[i][j] = cnt;
37            }
38        }
39        if (ways[0][0] == 0)
40            return new int[]{0, 0};
41        return new int[]{score[0][0], ways[0][0]};
42    }
43}