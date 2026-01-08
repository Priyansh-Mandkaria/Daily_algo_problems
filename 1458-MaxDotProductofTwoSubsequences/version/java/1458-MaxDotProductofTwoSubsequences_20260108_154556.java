// Last updated: 1/8/2026, 3:45:56 PM
1class Solution {
2    public int maxDotProduct(int[] nums1, int[] nums2) {
3        int n = nums1.length, m = nums2.length;
4        
5        int[][] dp = new int[n + 1][m + 1];
6
7        for (int i = 0; i <= n; i++) {
8            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
9        }
10
11        for (int i = 1; i <= n; i++) {
12            for (int j = 1; j <= m; j++) {
13                int product = nums1[i - 1] * nums2[j - 1];
14                
15                int max = product;
16                int candidate = product + dp[i - 1][j - 1];
17                if (candidate > max) max = candidate;
18                if (dp[i - 1][j] > max) max = dp[i - 1][j];
19                if (dp[i][j - 1] > max) max = dp[i][j - 1];
20                dp[i][j] = max;
21            }
22        }
23        
24        return dp[n][m];
25    }
26}