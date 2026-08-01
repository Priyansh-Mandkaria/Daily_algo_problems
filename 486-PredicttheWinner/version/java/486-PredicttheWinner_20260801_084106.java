// Last updated: 8/1/2026, 8:41:06 AM
1class Solution {
2    public boolean predictTheWinner(int[] nums) {
3        int n = nums.length;
4        if (n % 2 == 0) return true;
5        int[] dp = nums.clone();
6        for (int i = n - 2; i >= 0; --i) {
7            for (int j = i + 1; j < n; ++j) {
8                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
9            }
10        }
11        return dp[n - 1] >= 0;
12    }
13}