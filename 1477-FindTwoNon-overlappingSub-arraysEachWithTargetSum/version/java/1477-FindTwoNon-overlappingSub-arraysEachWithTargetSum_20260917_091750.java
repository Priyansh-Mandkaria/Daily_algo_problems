// Last updated: 9/17/2026, 9:17:50 AM
1class Solution {
2    public int minSumOfLengths(int[] A, int k) {
3        int n = A.length;
4        int res = n + 1, sum = 0, i = 0;
5        int[] dp = new int[n + 1];
6        Arrays.fill(dp, n);
7        for (int j = 0; j < n; j++) {
8            sum += A[j];
9            while (sum > k)
10                sum -= A[i++];
11            dp[j + 1] = dp[j];
12            if (sum == k) {
13                res = Math.min(res, j - i + 1 + dp[i]);
14                dp[j + 1] = Math.min(dp[j], j - i + 1);
15            }
16        }
17        return res == n + 1 ? -1 : res;
18    }
19}