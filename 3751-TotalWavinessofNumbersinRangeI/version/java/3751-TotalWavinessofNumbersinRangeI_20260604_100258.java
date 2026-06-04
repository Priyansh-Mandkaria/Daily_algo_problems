// Last updated: 6/4/2026, 10:02:58 AM
1class Solution {
2    private static final int MAX = 100005;
3    private static final int[] dp = new int[MAX];
4    private static final int[] pref = new int[MAX];
5    static {
6        for (int i = 100; i < MAX; i++) {
7            int d1 = i % 10;
8            int d2 = (i / 10) % 10;
9            int d3 = (i / 100) % 10;
10            int wave = 0;
11            if (d2 > Math.max(d3, d1) || d2 < Math.min(d3, d1))
12                wave++;
13            dp[i] = dp[i / 10] + wave;
14            pref[i] = pref[i - 1] + dp[i];
15        }
16    }
17    public int totalWaviness(int A, int B) {
18        return pref[B] - pref[A - 1];
19    }
20}