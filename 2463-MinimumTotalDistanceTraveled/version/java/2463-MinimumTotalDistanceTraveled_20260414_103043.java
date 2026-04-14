// Last updated: 4/14/2026, 10:30:43 AM
1import java.util.*;
2class Solution {
3    long[][] dp;
4    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
5        Collections.sort(robot);
6        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
7        int n = robot.size();
8        int m = factory.length;
9        dp = new long[n][m];
10        for (long[] row : dp) Arrays.fill(row, -1);
11        return solve(0, 0, robot, factory);
12    }
13    private long solve(int i, int j, List<Integer> robot, int[][] factory) {
14        int n = robot.size();
15        int m = factory.length;
16        if (i == n) return 0;
17        if (j == m) return (long)1e15;
18        if (dp[i][j] != -1) return dp[i][j];
19        long res = solve(i, j + 1, robot, factory); 
20        long cost = 0;
21        int pos = factory[j][0];
22        int limit = factory[j][1];
23        for (int k = 0; k < limit && i + k < n; k++) {
24            cost += Math.abs(robot.get(i + k) - pos);
25            res = Math.min(res, cost + solve(i + k + 1, j + 1, robot, factory));
26        }
27        return dp[i][j] = res;
28    }
29}