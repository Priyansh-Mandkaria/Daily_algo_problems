// Last updated: 9/21/2026, 9:14:46 AM
1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3        long[] ans = new long[k];
4        long[] dp = new long[k];
5        for (int num : nums) {
6            int x = num % k;
7            long[] next = new long[k];
8            next[x]++;
9            for (int r = 0; r < k; r++) {
10                int newR = (r * x) % k;
11                next[newR] += dp[r];
12            }
13            for (int r = 0; r < k; r++) {
14                ans[r] += next[r];
15            }
16            dp = next;
17        }
18        return ans;
19    }
20}