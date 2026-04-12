// Last updated: 4/12/2026, 12:33:49 PM
1class Solution {
2    private int dist(int a, int b) {
3        if (a == 26 || b == 26) 
4            return 0;
5        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
6    }
7    public int minimumDistance(String word) {
8        int[] dp = new int[27];
9        Arrays.fill(dp, 1000000);
10        dp[26] = 0;
11        int prev = word.charAt(0) - 'A';
12        for (int i = 1; i < word.length(); i++) {
13            int cur = word.charAt(i) - 'A';
14            int[] next_dp = new int[27];
15            Arrays.fill(next_dp, 1000000);
16            for (int free = 0; free < 27; free++) {
17                if (dp[free] >= 1000000) 
18                    continue;
19                next_dp[free] = Math.min(next_dp[free], dp[free] + dist(prev, cur));
20                next_dp[prev] = Math.min(next_dp[prev], dp[free] + dist(free, cur));
21            }
22            dp = next_dp;
23            prev = cur;
24        }
25        int res = 1000000;
26        for (int v : dp) 
27            res = Math.min(res, v);
28        return res;
29    }
30}